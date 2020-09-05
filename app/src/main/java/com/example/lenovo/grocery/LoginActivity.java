package com.example.lenovo.grocery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.Map;
import app.AppController;



public class LoginActivity extends AppCompatActivity {
    public Button but;
    public TextView sign;
    public EditText email, password;
    final String s1 = email.getText().toString().trim();
    final String s2 = password.getText().toString().trim();
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionManagement(getApplicationContext());

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        sign = findViewById(R.id.signup);
        but = findViewById(R.id.buttonContinue);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(sign);
                finish();
            }
        });

    }


    private void userLogin() {


        if (TextUtils.isEmpty(s1)) {
            email.setError("Please enter your email");
            email.requestFocus();
            return;
        }


        if (TextUtils.isEmpty(s2)) {
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }


        String tag_tag_arry = "json_array_req";
        String url = "https://api.androidhive.info/volley/person_array.json";
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonArrayRequest req =new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d(TAG, response.toString());
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                        pDialog.hide();
                        Intent sign = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(sign);
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //VolleyLog.e(TAG, "Error"+error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();


                pDialog.hide();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
               Map<String, String> params = new HashMap<String, String>();
               params.put("email", "asd@gmail.com");
               params.put("password", "password123");
               return params;

            }
        };
        AppController.getInstance().addToRequestQueue(req, tag_tag_arry);
    }

}
