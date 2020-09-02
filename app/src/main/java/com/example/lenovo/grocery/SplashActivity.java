package com.example.lenovo.grocery;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent sign = new Intent(SplashActivity.this,SignupActivity.class);
                startActivity(sign);
                finish();
                //Do something after 100ms
            }
        }, 3000);
        setContentView(R.layout.activity_splash);
    }
}
