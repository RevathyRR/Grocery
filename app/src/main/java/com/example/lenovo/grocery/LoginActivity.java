package com.example.lenovo.grocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public Button but;
    public TextView sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        but = findViewById(R.id.buttonContinue);
        sign = findViewById(R.id.signup);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(sign);
                finish();

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sign = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(sign);
                finish();


            }
        });

    }
}
