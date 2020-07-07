package com.voicediary;

import android.util.Log;
import android.widget.Toast;

public class SoundRecorder {

    private static final String TAG = "Sound Recorder" ;

    // record sound from the device using media
    public void startRecording(MainActivity context) {
        Toast.makeText(context, "working connection to startRecording ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In startRecording  ");
    }

    // stop the recording from the device
    public void stopRecording(MainActivity context) {
        Toast.makeText(context, "working connection to stopRecording", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   stopRecording");
    }
}
