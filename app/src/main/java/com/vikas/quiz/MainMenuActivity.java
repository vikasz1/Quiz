package com.vikas.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button button1 = findViewById(R.id.quiz1);
        Button button2 = findViewById(R.id.quiz2);
        Button button3 = findViewById(R.id.quiz3);
        Button button4 = findViewById(R.id.quiz4);
        Button button5 = findViewById(R.id.quiz5);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quiz1:
                Intent intent1 = new Intent(MainMenuActivity.this,Quiz1.class);
                startActivity(intent1);
                break;
            case R.id.quiz2:
                Intent intent2 = new Intent(MainMenuActivity.this,Quiz2.class);
                startActivity(intent2);
                break;
            case R.id.quiz3:
                Intent intent3 = new Intent(MainMenuActivity.this,Quiz3.class);
                startActivity(intent3);
                break;
            case R.id.quiz4:
                Intent intent4 = new Intent(MainMenuActivity.this,Quiz4.class);
                startActivity(intent4);
                break;
            case R.id.quiz5:
                Intent intent5 = new Intent(MainMenuActivity.this,Quiz5.class);
                startActivity(intent5);
                break;

        }
    }
}