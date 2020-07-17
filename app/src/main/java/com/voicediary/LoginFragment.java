package com.voicediary;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment {
  private static final String TAG = "Login";

  /**
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup
    container, @Nullable Bundle savedInstanceState){
      FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
      if ( user == null) {

        return inflater.inflate(R.layout.fragment_login, container, false);

      }
      else {
        Toast.makeText(this.getContext(), "Already loged in", Toast.LENGTH_SHORT).show();
        return null;
      }
  }

}