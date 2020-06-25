package com.voicediary;

import android.util.Log;
import android.widget.Toast;

public class UserAuthenticator {


    private static final String TAG = "UserAuthenticator class" ;


    // Password authentication in firebase
    private boolean authenticateUser(MainActivity context) {
        Toast.makeText(context, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
        return true;
    }

    // create a new user in firebase
    private boolean  createUser(MainActivity context) {
        Toast.makeText(context, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
        return true;

    }
}
