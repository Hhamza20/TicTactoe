package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent splash=new Intent(SplashScreen.this, MainActivity2.class);
        new Handler().postDelayed(() -> {
            startActivity(splash);
            finish();
        },3000);
    }
}