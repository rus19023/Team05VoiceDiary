package com.voicediary;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class UserPreferences {

    public static final String SHARED_PREF = "sharedPreferences";
    private static final String TAG = "Our Activity";
    private static final String PASSWORD = "password";

    public static void saveSharedPreferencesPassword(MainActivity context, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PASSWORD, password);
        editor.apply();
        Toast.makeText(context, "Password saved", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "saveSharedPreferences: password saved");
    }

    public static String loadSavedSharePreferencesPassword(MainActivity context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        String password = sharedPreferences.getString(PASSWORD, "");

        if (password != "") {
            Toast.makeText(context, "Password retrieved ", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "loadSavedSharePreferences: ");
            return password;
        }
        return "";
    }
}





