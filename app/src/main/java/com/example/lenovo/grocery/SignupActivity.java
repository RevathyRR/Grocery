package com.example.lenovo.grocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    public TextView log;
    public EditText pass,repass,email;
    public Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        log=findViewById(R.id.login);
        sign=findViewById(R.id.buttonContinue);
        pass=findViewById(R.id.editTextPassword);
        repass=findViewById(R.id.editTextConfirm);
        email=findViewById(R.id.editTextEmail);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si=new Intent(SignupActivity.this,MainActivity.class);
                startActivity(si);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(si);
            }
        });

    }
}
