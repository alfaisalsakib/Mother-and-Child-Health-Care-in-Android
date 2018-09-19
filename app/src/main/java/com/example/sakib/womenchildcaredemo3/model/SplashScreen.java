package com.example.sakib.womenchildcaredemo3.model;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.sakib.womenchildcaredemo3.MainActivity;
import com.example.sakib.womenchildcaredemo3.*;

public class SplashScreen extends AppCompatActivity {

    public static final long DURATION = 5000;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splashScreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, DURATION);

        YoYo.with(Techniques.Pulse).duration(1000).repeat(1).playOn(imageView);
    }
}
