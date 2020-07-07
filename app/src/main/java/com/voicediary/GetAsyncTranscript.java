package com.voicediary;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

public class GetAsyncTranscript implements Runnable {
    private static final String TAG = "GetTranscription";
    private MainActivity context;
    private MediaPlayer voiceRecord;
    private String text;


    /**
     * Sets up the runnable to be called. It needs the MainActivity so it can run code on the
     * UI thread, and also the voice recorded so that it can get transcribed to text.
     *
     * @param context
     * @param
     */

    public GetAsyncTranscript(MainActivity context, MediaPlayer voiceRecord) {
        this.context = context;
        this.voiceRecord = voiceRecord;

    }

    @Override
    public void run() {
        // request transcription from the API

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is code that will now run on the UI thread. Call the function in
                // MainActivity that will update the UI correctly.

            }

            /*here must implement the runnable*/
        });}

    public  String requestTranscription () {
        Toast.makeText(context, "working connection to requestTranscription", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  requestTranscription");
        return text;
    }



    // receive text from the API as json and put it in a string
    public String receiveText() {
        Toast.makeText(context, "working connection to  receiveText", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In receiveText  ");
        return text;
    }


}