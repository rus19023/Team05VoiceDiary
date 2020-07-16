package com.voicediary;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public abstract class RecordingFragment extends Fragment  implements View.OnClickListener {
    private static final String TAG = "Register Login";public static final int RECORD_AUDIO = 0;
    private MediaRecorder myAudioRecorder;
    private String output = null;
    private Button start, stop, play;
    private boolean permissionToRecordAccepted = false;
    private boolean permissionToWriteAccepted = false;
    private String [] permissions = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};

    protected RecordingFragment(Button start, Button stop, Button play) {
        this.start = start;
        this.stop = stop;
        this.play = play;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In Recording Fragment ");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        int requestCode = 200;
        requestPermissions(permissions, requestCode);

        return inflater.inflate(R.layout.fragment_recording, container, false);
    }
    @Override public void onClick(View v){
        switch (v.getId()){
            case R.id.imageBtnRecord:
                start(v);
                break;
            case R.id.imageBtnRecordStop:
                stop(v);
                break;
            case R.id.imageBtnPause:
                try {
                    play(v);
                }
                catch (IOException e){
                    Log.i("IOException", "Error in play");
                }
                break;
            default:
                break;
        }
    }
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 200:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                permissionToWriteAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) Activity.super.finish();
        if (!permissionToWriteAccepted ) MainActivity.super.finish();
    }
    public void start(View view){
        try{
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        start.setEnabled(false);
        stop.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_SHORT).show();
    }
    public void stop(View view){
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;
        stop.setEnabled(false);
        play.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_SHORT).show();
    }
    public void play(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayer m = new MediaPlayer();
        m.setDataSource(output);
        m.prepare();
        m.start();
        Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_SHORT).show();
    }

}

