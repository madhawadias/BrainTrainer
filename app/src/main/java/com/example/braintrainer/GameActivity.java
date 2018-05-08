package com.example.braintrainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    //Array used to store the mathematical operators
    private static String[] operator = {"+", "-", "/", "*"};
    //Creating TextViews
    private TextView randomTextView;
    private TextView resultTextView;
    private TextView countDownTextView;
    private TextView userAnswerTextView;
    //Creating Buttons
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bMinus,bDel,bHash;
    //String Buffers
    private StringBuffer equ = new StringBuffer(); // Used to store the randomly generated equation
    private StringBuffer userAnswer = new StringBuffer(); // Used to store the Answer given by the User
    //Counts
    private int digitCount; // Counts the no.of digits entered by the user
    private static int questionCount; // Number of questions displayed in a particular session
    private int result; // Result of the equation
    private int numOfIntegers; // Number of integers that will be in the equation (Depends on the difficulty level)
    private static int marks = 0; // Marks
    private int timeRemaining = 0; // Time remaining in the Timer
    private int nums[]=new int[2];
    private SharedPreferences saveData; // Used to parse values from one activity to another
    private final String FILE_NAME = "saveStats";
    private String answerFinal = "";
    private String number = "";
    private boolean continueIsPressed = false;
    private boolean isHintsPressed = false; // Hints

    @Override
    protected void onCreate(Bundle savedInstanceState) { //This is called when the activity first starts up.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Switch to toggle Hints
        Switch hintsSwitch = (Switch) findViewById(R.id.switchHints);
        hintsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isHintsPressed = true; // When switch is ON

                } else {
                    isHintsPressed = false; // When switch is OFF
                }
            }
        });

        //Saves the data of a particular session to be accessed when continuing the game
        saveData = getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        //========================= TEXT VIEWS ==============================
        randomTextView = (TextView) findViewById(R.id.randomWindow);
        resultTextView = (TextView) findViewById(R.id.Result);
        countDownTextView = (TextView) findViewById(R.id.countDown);
        userAnswerTextView = (TextView) findViewById(R.id.userAnswer);
        //===================================================================

        numOfIntegers = getIntent().getExtras().getInt("level");
        continueIsPressed = getIntent().getExtras().getBoolean("resumeGame");

//        if(continueIsPressed = true){
//            restore();
//        }

        calculation();
        countdown();

        //=============== BUTTONS ==================
        b1=(Button)findViewById(R.id.one);
        b2=(Button)findViewById(R.id.two);
        b3=(Button)findViewById(R.id.three);
        b4=(Button)findViewById(R.id.four);
        b5=(Button)findViewById(R.id.five);
        b6=(Button)findViewById(R.id.six);
        b7=(Button)findViewById(R.id.seven);
        b8=(Button)findViewById(R.id.eight);
        b9=(Button)findViewById(R.id.nine);
        b0=(Button)findViewById(R.id.zero);
        bMinus=(Button)findViewById(R.id.Minus);
        bDel=(Button)findViewById(R.id.Del);
        bHash=(Button)findViewById(R.id.hash);
        //==========================================

        //============= B U T T O N   A C T I O N S ================

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                userAnswer.append(1);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "1";
                answerFinal = answerFinal + number;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(2);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "2";
                answerFinal = answerFinal + number;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(3);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "3";
                answerFinal = answerFinal + number;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(4);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "4";
                answerFinal = answerFinal + number;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(5);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "5";
                answerFinal = answerFinal + number;
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(6);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "6";
                answerFinal = answerFinal + number;
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(7);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "7";
                answerFinal = answerFinal + number;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(8);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "8";
                answerFinal = answerFinal + number;
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(9);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "9";
                answerFinal = answerFinal + number;
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append(0);
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "0";
                answerFinal = answerFinal + number;
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAnswer.append("-");
                userAnswerTextView.setText(userAnswer.toString());
                digitCount++;
                number = "-";
                answerFinal = answerFinal + number;
            }
        });
        bDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answerFinal!="") {  // Validating error caused when pressing Delete without user answer
                    userAnswer.delete(digitCount-1,digitCount);
                    userAnswerTextView.setText(userAnswer.toString());
                    digitCount--;
                    answerFinal.substring(0,answerFinal.length()-1);
                    Log.d("USER ANSWER", String.valueOf(userAnswer));
                }

            }
        });
        bHash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answerFinal!="") { // Validating error caused when pressing Hash without user answer
                    if(isHintsPressed){ // When HINTS switch is ON
                        if(result > Integer.parseInt(userAnswerTextView.getText().toString())){
                            resultTextView.setText("Greater");
                        }if(result < Integer.parseInt(userAnswerTextView.getText().toString())) {
                            resultTextView.setText("Less");
                        }if (result == Integer.parseInt(userAnswerTextView.getText().toString())) {
                            resultTextView.setText("Correct");
                            resultTextView.setTextColor(Color.GREEN);
                            marks = marks + 100 / (10 - timeRemaining);
                            Log.d("MARKS", String.valueOf(marks));
                        }
                    }else {
                        if (result == Integer.parseInt(userAnswerTextView.getText().toString())) {
                            resultTextView.setText("Correct");
                            resultTextView.setTextColor(Color.GREEN);
                            marks = marks + 100 / (10 - timeRemaining);
                            Log.d("MARKS", String.valueOf(marks));
                        } else {
                            resultTextView.setText("Wrong");
                            resultTextView.setTextColor(Color.RED);

                        }
                    }
                }
            }
        });


    }
    /** Generates Random Equation and Calculates the Result **/
    public void calculation(){

        int skip = 0;

        for(int i=0; i<numOfIntegers; i++){
            int randomNum = randomInt(10)+1;
            if (skip == 0) {
                nums[0] = randomNum;
            } else {
                nums[1] = randomNum;
            }


            if (i <= numOfIntegers-1) {
                String opt = null;
                if (skip>0) {
                    opt = randomOperator();
                    equ.append(opt);
                }
                equ.append(randomNum);
                if(skip>0 && opt.equals("+")){
                    result = nums[0] + nums[1];

                }
                if(skip>0 && opt.equals("-")){
                    result = nums[0] - nums[1];

                }
                if(skip>0 && opt.equals("*")){
                    result = nums[0] * nums[1];

                }
                if(skip>0 && opt.equals("/")){
                    result = nums[0] / nums[1];

                }
                if (skip>0) {
                    nums[0]=result;
                }
                skip ++;
            }
        }

        equ.append(" = ");
        StringBuffer finalEqu = new StringBuffer();
        finalEqu.append(equ);
        randomTextView.setText(finalEqu.toString());

    }

    private String randomOperator() {
        int random = randomInt(3);
        return operator[random];
    }

    private int randomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public void restart(){
        this.recreate();
    }

    /** Timer - Counts 10 seconds to answer each question **/
    public void countdown(){
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDownTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
                timeRemaining = (int)millisUntilFinished/1000;
            }

            public void onFinish() {
                if (questionCount<9) {
                    questionCount++;
                    Log.d("QUESTION COUNT", String.valueOf(questionCount));
                    restart();
                }else{
                    Intent myIntent = new Intent(GameActivity.this, MarksActivity.class);
                    myIntent.putExtra("TOTALMARKS", marks);
                    startActivity(myIntent);
                    GameActivity.this.finish();


                }
            }
        }.start();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

        saveGame();
        Intent myIntent = new Intent(GameActivity.this, MainActivity.class);
        finish();
        startActivity(myIntent);

    }


    public void saveGame(){
        SharedPreferences.Editor editData = saveData.edit();
        editData.putInt("difficulty",numOfIntegers); // Gets the difficulty level
        editData.putInt("questionCount",questionCount); // Gets the number of questions answered
        editData.putInt("marks",marks); // Gets the number of marks
        editData.commit();

    }


    public void restore(){
        if(continueIsPressed){
            numOfIntegers = saveData.getInt("difficulty",2);
            questionCount = saveData.getInt("questionCount",0);
            marks = saveData.getInt("marks",0);
        }



    }


}
