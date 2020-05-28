package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.example.ineedmoney.R;

public class MainPage extends AppCompatActivity {
    public Button addBaseButton;
    public Button openBaseButton;
    public Button exitButton;
    public Button analysis;
    public Button formula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBaseButton = (Button) findViewById(R.id.button);
        addBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        openBaseButton = (Button) findViewById(R.id.button2);
        openBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        exitButton = (Button) findViewById(R.id.button5);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMethod();
            }
        });
        analysis = (Button) findViewById(R.id.button4);
        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        formula = (Button) findViewById(R.id.button3);
        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, AddQuestion.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, activity_base.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, image_view.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, formulas.class);
        startActivity(intent);
    }


    public void callMethod(){
        finish();
    }

}