package com.example.braintrainer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Goes to the NEW GAME ACTIVITY **/
    public void newGame(View view) {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
        finish();
    }

    /** Shows the ABOUT POPUP WINDOW **/
    public void about(View view) {
//        Intent intent = new Intent(this, AboutActivity.class);
//        startActivity(intent);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Welcome to Games of Brains! The game consists of four levels. " +
                "To begin, the level of the game should be selected. The four levels are: " +
                "Novice, Easy, Medium, Guru. . You have 10 seconds to answer each question. " +
                "The faster you answer, the more marks you get. To submit the answer ‘‘#’’ " +
                "should be selected..... Good Luck. ").setCancelable(false).
                setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("About Game");
        alert.show();

    }

    /** Goes to the CONTINUE GAME ACTIVITY **/
    public void continueGame(View view){
        Intent resumeIntent = new Intent(this, GameActivity.class);
        boolean isResume = true;
        resumeIntent.putExtra("resumeGame",isResume );
        startActivity(resumeIntent);
        finish();

    }

    /** EXITS the game **/
    public void clickexit(View v) {

        //An option is given to save the last played game
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to save the game?").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Save Game");
        alert.show();

    }
}
