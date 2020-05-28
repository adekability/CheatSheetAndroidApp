package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.ineedmoney.R;

public class image_view extends AppCompatActivity {
    public ImageView image;
    private Button searchGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        image = (ImageView) findViewById(R.id.imageView);
        searchGoogle = (Button) findViewById(R.id.button11);
        image.setImageResource(R.drawable.esep);
        searchGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?rlz=1C1CHBF_ruKZ887KZ887&sxsrf=ALeKk00vmSWFizkf35gJFaXsphtraejzww%3A1587663805993&ei=vdOhXp2RPMfY-wS6-Y6gAQ&q=%D0%A2%D0%B5%D2%A3%D1%81%D1%96%D0%B7%D0%B4%D1%96%D0%BA%D1%82%D1%96+%D1%88%D0%B5%D1%88%D1%96%D2%A3%D1%96%D0%B7%3A+2x%2B1%3E0&oq=%D0%A2%D0%B5%D2%A3%D1%81%D1%96%D0%B7%D0%B4%D1%96%D0%BA%D1%82%D1%96+%D1%88%D0%B5%D1%88%D1%96%D2%A3%D1%96%D0%B7%3A+2x%2B1%3E0&gs_lcp=CgZwc3ktYWIQAzoECAAQRzoECCMQJzoCCAA6BAgAEEM6BggAEAoQQzoGCAAQFhAeOgUIIRCgAVCPFVjckwFgkqgBaAdwBHgCgAGnB4gBg4kBkgEKMy0xNS4zLjguN5gBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwjd47bJjP_oAhVH7J4KHbq8AxQQ4dUDCAw&uact=5"));
                startActivity(browserIntent);
            }
        });
    }
}
