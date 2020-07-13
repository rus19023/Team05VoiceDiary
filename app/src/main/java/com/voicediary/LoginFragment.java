package com.voicediary;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoginFragment extends Fragment {
  private static final String TAG = "Login";

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


    return inflater.inflate(R.layout.fragment_login, container, false);



  }

  /*public void userLogin(View view) {
    // check internet connection
   // CheckInternet checkInternet = new CheckInternet();
   // if (!checkInternet.isConnected(Login.this));


    // validate phone number and password
    //if (!validateFields()) {
      //progressbar.setVisibility(View.VISIBLE);

      // get data from fields
      //String _phone_number = phoneNumber.getEditText().getText().toString().trim();
      //final String _password = password.getEditText().getText().toString().trim();
      //if (_phone_number.charAt(0) == 0);
      //final String _completePhoneNumber = "+" + countryCodePicker.getFullNumber() + _phone_number;

      // get user data from Firebase


      // create session
      //SessionManager sessionManager = new SessionManager(this);
      //sessionManager.createLoginSession(_username, _password);

      //startActivity(new Intent(getApplicationContext()Dashboard.class));

    //}
  }

  public void userLogout() {

  }*/

}