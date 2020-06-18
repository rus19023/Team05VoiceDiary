package com.voicediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Our Activity" ;
    String transcription;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
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