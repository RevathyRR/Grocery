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
    Button btnLogout;
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManagement(getApplicationContext());

        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        TextView lblPhone = (TextView) findViewById(R.id.lblPhone);
        TextView lblPassword = (TextView) findViewById(R.id.lblPass);



        // Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();


        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.isLoggedIn();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();


        String email = user.get(SessionManagement.KEY_EMAIL);
        String password = user.get(SessionManagement.KEY_PHONE);
        String phone = user.get(SessionManagement.KEY_PASS);


        // displaying user data
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
        lblPassword.setText(Html.fromHtml("Password: <b>" + password + "</b>"));
        lblPhone.setText(Html.fromHtml("Phone: <b>" + phone + "</b>"));




        /**
         * Logout button click event
         * */
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