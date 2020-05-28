package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ineedmoney.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText3;
    private EditText editText5;
    private Button button10;
    private TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText3.setHint("Қолданушы есімі");
        editText5.setHint("Құпия сөз");
        editText5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            button10.performClick();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        button10 = (Button) findViewById(R.id.button10);
        textView5 = (TextView) findViewById(R.id.textView5);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText3.getText().toString().equals("Назгуль") && (editText5.getText().toString().equals("ену2020"))){
                    openActivity1();
                }
                else{
                    textView5.setTextColor(Color.RED);
                    textView5.setText("Құпия сөз не тіркелуші\n   \tесімі тіркелмеген");
                }
            }
        });
    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}
