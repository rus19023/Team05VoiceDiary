package com.voicediary;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MediaActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        if (player == null) {
            //player = MediaPlayer.create(this, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View view) {
        if (player != null) {
            player.pause();
        }
    }

    public void record(View v) {}

    public void stop(View v) {
        stopPlayer();

    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "working connection to startRecording ", Toast.LENGTH_SHORT).show();

        }
    }
    /*
    @Override
    protected void OnStop() {
        super.OnStop();
        stopPlayer();
    }
    */
}

