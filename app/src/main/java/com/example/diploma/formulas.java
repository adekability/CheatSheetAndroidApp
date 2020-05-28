package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.ineedmoney.R;

public class formulas extends AppCompatActivity {
    public ImageView image;
    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);
        image = (ImageView) findViewById(R.id.iv_bollywood);
        image.setImageResource(R.drawable.esep);

        image1 = (ImageView) findViewById(R.id.iv_hollywood);
        image1.setImageResource(R.drawable.esep3);

        image2 = (ImageView) findViewById(R.id.iv_animated);
        image2.setImageResource(R.drawable.esep4);

        image3 = (ImageView) findViewById(R.id.iv_hindhi_dub);
        image3.setImageResource(R.drawable.formula);
    }
}
