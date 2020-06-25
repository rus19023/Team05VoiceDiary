package com.voicediary;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_login);
  }

  public void userLogin(View view) {
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

  }

}