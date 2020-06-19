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


  /* ----------- basic of Shared preferences -----------

   create a share preference and a editor to work with that preference
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();


 create a new instance of intent to receive data from another activity
        Intent intent = getIntent();

  get the data send by the intent invoked
         book = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
         chapter = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
         verse = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
save the sharedPreferences values
        editor.putString(MainActivity.EXTRA_MESSAGE1 ,book);

        editor.putString(MainActivity.EXTRA_MESSAGE2 , chapter);

        editor.putString(MainActivity.EXTRA_MESSAGE3 , verse);

        // Why apply() and not commit() ?
        // See: http://stackoverflow.com/questions/5960678/whats-the-difference-between-commit-and-apply-in-shared-preference
        editor.apply();

retrieve the sharedPreferences values

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(R.integer.saved_high_score_default_key);
        int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue);
*/




