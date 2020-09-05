package com.example.lenovo.grocery;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManagement(getApplicationContext());

        TextView lblPass = (TextView) findViewById(R.id.lblPass);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);

        // Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        String email = user.get(SessionManagement.KEY_EMAIL);
        String password = user.get(SessionManagement.KEY_PASS);
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
        lblPass.setText(Html.fromHtml("Password: <b>" + password + "</b>"));
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();
            }


        });
    }
}
