package com.voicediary;

import android.media.MediaPlayer;

public class GetAsyncTranscript implements Runnable {
    private MainActivity activity;
    private MediaPlayer voiceRecord;


    /**
     * Sets up the runnable to be called. It needs the MainActivity so it can run code on the
     * UI thread, and also the voice recorded  so that it can get transcribe to text.
     *
     * @param activity
     * @param
     */

    public GetAsyncTranscript(MainActivity activity, MediaPlayer voiceRecord) {
        this.activity = activity;
        this.voiceRecord = voiceRecord;


    }
    @Override
    public void run() {
        /*here must implement the runnable*/
    }

}

