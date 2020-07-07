package com.voicediary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Opens page to manage diary entries.
 * @author Doris Rush-Lopez, Carlos Gerez, Gabriel Hayes, Joseph Itiose
 * @version 1.0
 * @since 1.0
 */
public class EntriesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entries, container, false);
    }
}
