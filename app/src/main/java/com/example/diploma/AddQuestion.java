package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.ineedmoney.R;

public class AddQuestion extends AppCompatActivity {
    public EditText textQuestion;
    public EditText textAnswer;
    public Button setToBase;
    public Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        textQuestion = (EditText) findViewById(R.id.editText);
        textQuestion.setHint("Аты-жөні");
        textAnswer = (EditText) findViewById(R.id.editText2);
        textAnswer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            addQuestion();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        textAnswer.setHint("Мамандығы/тобы");
        setToBase = (Button) findViewById(R.id.button2);
        setToBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuestion();
            }
        });
        exitButton = (Button) findViewById(R.id.button6);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        textQuestion.setLongClickable(true);
    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
    public void addQuestion() {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        String question = textQuestion.getText().toString();
        String answer = textAnswer.getText().toString();
        String shortcode = textQuestion.getText().toString().replaceAll("\\D+","");
        if (shortcode.isEmpty()){
            shortcode = "No Digits";
        }
        Questions questions = new Questions(question,  shortcode,answer);
        dbHandler.addHandler(questions);
        textQuestion.setText("");
        textAnswer.setText("");
    }
}
