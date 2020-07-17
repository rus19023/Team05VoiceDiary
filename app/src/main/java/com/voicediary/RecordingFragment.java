package com.voicediary;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecordingFragment extends Fragment {

    private static final String TAG = "RecordingFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In Recording Fragment ");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        return inflater.inflate(R.layout.fragment_recording, container, false);
    }
}
