package com.voicediary;

import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public abstract class RecordingFragment extends Fragment  implements View.OnClickListener {

    private static final String TAG = "RecordingFragment";
    private MediaRecorder myAudioRecorder;
    private String output = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In Recording Fragment ");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        return inflater.inflate(R.layout.fragment_recording, container, false);
    }


}

