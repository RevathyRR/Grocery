package com.example.lenovo.grocery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.HashMap;

public class SessionManagement {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mCtx;
    private static SessionManagement mInstance;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "AndroidHivePref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASS = "password";
    public static final String KEY_PHONE = "phone";



    // Constructor
    SessionManagement(Context context) {
        mCtx = context;

    }

    public static synchronized SessionManagement getInstance(Context context) {
        if (mInstance == null ) {
            mInstance = new SessionManagement(context);
        }
        return mInstance;
    }


    public void userLogin(User user) {
        pref = mCtx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PHONE, user.getPhone());
        editor.putString(KEY_PASS, user.getPassword());
        editor.apply();
    }
    /**
     * Create login session
     * */
   /* public void createLoginSession(String email, String password){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing password in pref
        editor.putString(KEY_PASS, password);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // commit changes
        editor.commit();
    } */

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
 /*   public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(mCtx, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            mCtx.startActivity(i);
        }

    } */



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user password

        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));

        user.put(KEY_PASS, pref.getString(KEY_PASS, null));


        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(mCtx, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        mCtx.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        pref = mCtx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return pref.getBoolean(IS_LOGIN, false);
    }
}
