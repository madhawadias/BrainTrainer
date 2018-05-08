package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MarksActivity extends AppCompatActivity {

    TextView marksTextView;

    /** Displays the rules of the game **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        Intent mIntent = getIntent();
        int totalMarks = mIntent.getIntExtra("TOTALMARKS", 0);
        marksTextView = (TextView) findViewById(R.id.Marks);
        marksTextView.setText(String.valueOf(totalMarks));


    }

    public void mainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
