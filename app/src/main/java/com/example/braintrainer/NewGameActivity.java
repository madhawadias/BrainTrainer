package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
    }

    public void difficulty(View view) {

        Intent intent = new Intent(this, GameActivity.class);

        // Difficulty is Selected
        switch(view.getId()){
            case R.id.noviceBut :
                intent.putExtra("level", 2);
                break;
            case R.id.easyBut :
                intent.putExtra("level", 3);
                break;
            case R.id.mediumBut :
                intent.putExtra("level", 4);
                break;
            case R.id.guruBut :
                intent.putExtra("level", 5);
                break;
            default:
                break;

        }
        finish();
        startActivity(intent);
    }

}
