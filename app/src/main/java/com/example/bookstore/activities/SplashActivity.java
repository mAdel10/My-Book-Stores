package com.example.bookstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bookstore.R;
import com.example.bookstore.helpers.Constants;
import com.example.bookstore.helpers.SharedPreference;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPreference.getToken(getApplicationContext()) != null) {
                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(SplashActivity.this, LogInActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, Constants.SPLASH_TIME_OUT);
    }
}
