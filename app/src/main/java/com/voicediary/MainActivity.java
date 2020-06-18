package com.voicediary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Our Activity" ;
    private static final String VOICE_DIARY_PREFS = "voiceDiarySessionInfo";
    String transcription;
    private static final String IS_LOGIN = "isLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* ----------- basic of Shared preferences -----------*/
        // create a share preference and a editor to work with that preferenc
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.Context.MODE_PRIVATE);


        setContentView(R.layout.activity_main);
        // retrieve the sharedPreferences values
        String saved_username = sharedPrefs.getString("username", "");
        String saved_password = sharedPrefs.getString("password", "");
        String saved_isLogin = sharedPrefs.getString("password", "");

        // Save the scripture variable contents to log
        //Log.i(String.format("Retrieved settings %s, %s, %s", saved_isLogin, saved_username, saved_password));
        Log.d(getClass().getName(), String.format("About to create intent with %s", saved_isLogin, saved_username, saved_password));

        Toast.makeText(getApplicationContext(), String.format("Preferences %s %s:%s retrieved.",
                saved_isLogin, saved_username, saved_password), Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        super.onPause();

        /* ----------- basic of Shared preferences -----------*/
        // create a share preference and a editor to work with that preferenc
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPrefs.edit();

        // save the sharedPreferences values
        editor.putString(MainActivity.IS_LOGIN, "isLoggedIn");
        editor.putString(MainActivity.KEY_USERNAME, "user5974");
        editor.putString(MainActivity.KEY_PASSWORD, "password51");
        // Why apply() and not commit() ?
        // See: http://stackoverflow.com/questions/5960678/whats-the-difference-between-commit-and-apply-in-shared-preference
        editor.apply();

        // See https://developer.android.com/guide/topics/ui/notifiers/toasts.html
        Toast.makeText(this, "Preferences have been saved.", Toast.LENGTH_SHORT).show();



    }



    private void authenticateUser(View view){
        Toast.makeText(this, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
    }
    public void startRecording(View view) {
        Toast.makeText(this, "working connection to startRecording ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In startRecording  ");
    }
    public void stopRecording(View view){
        Toast.makeText(this, "working connection to stopRecording", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   stopRecording");
    }
    public void requestTranscription(View view){
        Toast.makeText(this, "working connection to requestTranscription", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  requestTranscription");
    }
    public void seeTranscription(){
        Toast.makeText(this, "working connection to seeTranscription ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  seeTranscription ");
    }
    public void saveNewEntry(View view){
        Toast.makeText(this, "working connection to  saveNewEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   ");
    }
    public void deleteSavedEntry(View view){
        Toast.makeText(this, "working connection to deleteSavedEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  saveNewEntry ");
    }
    public void retrieveEntry(View view){
        Toast.makeText(this, "working connection to retrieveEntry ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  retrieveEntry ");
    }
    public void receiveText(View view){
        Toast.makeText(this, "working connection to  receiveText", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In receiveText  ");
    }

    public void callSignUpScreen(View view) {
        Toast.makeText(this, "working connection to callSignUpScreen", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In signup screen  ");
    }

    public void onSaveClick(View view) {
        Toast.makeText(this, "working connection to onSaveClick", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "in onSaveclick");
    }

    public void onRevertClick(View view) {
        Toast.makeText(this, "working connection to onRevertClick", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In onRevertclick ");
    }

    public void loginUser(View view) {
        Toast.makeText(this, "working connection to loginUser", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In loginUser  ");
    }
}