package com.kldv.gibought;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goBanner();
            }
        }, 3200);
    }

    private void goBanner() {
        Intent intent = new Intent(
                SplashScreen.this,BannerActivity.class
        );
        startActivity(intent);
        finish();
    }
    }