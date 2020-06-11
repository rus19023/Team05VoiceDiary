package com.voicediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Our Activity" ;
    String transcription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private authenticateUser(){
        Toast.makeText(this, "working conection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
    }
    public startRecording() {
        Toast.makeText(this, "working conection to startRecording ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In startRecording  ");
    }
    public stopRecording(){
        Toast.makeText(this, "working conection to stopRecording", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   stopRecording");
    }
    public requestTranscription(){
        Toast.makeText(this, "working conection to requestTranscription", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  requestTranscription");
    }
    public seeTranscription(){
        Toast.makeText(this, "working conection to seeTranscription ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  seeTranscription ");
    }
    public saveNewEntry(){
        Toast.makeText(this, "working conection to  saveNewEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   ");
    }
    public deleteSavedEntry(){
        Toast.makeText(this, "working conection to deleteSavedEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  saveNewEntry ");
    }
    public retrieveEntry(){
        Toast.makeText(this, "working conection to retrieveEntry ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  retrieveEntry ");
    }
    public receiveText(){
        Toast.makeText(this, "working conection to  receiveText", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In receiveText  ");
    }


}