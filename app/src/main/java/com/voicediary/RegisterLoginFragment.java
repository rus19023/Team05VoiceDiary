package com.voicediary;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterLoginFragment extends Fragment {
    private static final String TAG = "Register Login";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "In  register login ");

        return inflater.inflate(R.layout.fragment_recording, container, false);
    }
}
