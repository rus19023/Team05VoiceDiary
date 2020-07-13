package com.voicediary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

import static com.voicediary.R.id.fade;
import static com.voicediary.R.id.nav_login;
import static com.voicediary.R.id.nav_view;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private static final String TAG = "MainActivity";
  String transcription;
  private DrawerLayout drawer;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(nav_view);
    navigationView.setNavigationItemSelectedListener(this);



    ActionBarDrawerToggle toggle =
            new ActionBarDrawerToggle(
                    this,
                    drawer,
                    toolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    // *** need to figure out user registered/logged in logic and implement here ***
    //  separate fragments for register and login





    if (savedInstanceState == null) {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.main_view, new RegisterLoginFragment())
              .commit();
      navigationView.setCheckedItem(R.id.nav_record);
    }
  }



  // show transcription received
  public String seeTranscription() {
    Toast.makeText(this, "working conection to seeTranscription ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  seeTranscription ");
    return transcription;
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.nav_record:
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_view, new EntriesFragment())
            .commit();
        break;
      case R.id.nav_print_menu:
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_view, new PrintMenuFragment())
            .commit();
        break;
      case R.id.nav_entries:
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_view, new EntriesFragment())
            .commit();
        break;
      case R.id.nav_login:
        Toast.makeText(this, "This menu item will connect to Login", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_view, new LoginFragment())

                .commit();

        break;
      case R.id.nav_logout:
        Toast.makeText(this, "This menu item will connect to Logout", Toast.LENGTH_SHORT).show();
        UserAuthenticator newUser = new UserAuthenticator();
        newUser.logOutUser(this);
        break;
    }


    Toast.makeText(this, "I am inmediatelly after item will connect to Login", Toast.LENGTH_SHORT).show();

    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  public void authenticateUser(View view) {
    Toast.makeText(this, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
    UserAuthenticator newUser = new UserAuthenticator();
    newUser.createUser(this);


    Log.d(TAG, "In authenticateUser");
  }

  public void pauseRecording(View view) {
    Toast.makeText(this, "working connection to pauseRecording  ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In pauseRecording");
  }

  public void startRecording(View view) {
    Toast.makeText(this, "working connection to startRecording ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In startRecording");
  }

  public void stopRecording(View view) {
    Toast.makeText(this, "working connection to stopRecording", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In   stopRecording");
  }

  public void requestTranscription(View view) {
    Toast.makeText(this, "working connection to requestTranscription", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  requestTranscription");
  }

  public void viewTranscription() {
    Toast.makeText(this, "working connection to viewTranscription ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  viewTranscription");
  }

  public void saveNewEntry(View view) {
    Toast.makeText(this, "working connection to  saveNewEntry", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In saveNewEntry");
  }

  public void deleteSavedEntry(View view) {
    Toast.makeText(this, "working connection to deleteSavedEntry", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  saveNewEntry");
  }

  public void retrieveEntry(View view) {
    Toast.makeText(this, "working connection to retrieveEntry ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  retrieveEntry");
  }

  public void receiveText(View view) {
    Toast.makeText(this, "working connection to receiveText", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In receiveText");
  }

  public void callSignUpScreen(View view) {
    Toast.makeText(this, "working connection to callSignUpScreen", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In signup screen");
  }

  public void onSaveClick(View view) {
    Toast.makeText(this, "working connection to onSaveClick", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "in onSaveclick");
  }

  public void onRevertClick(View view) {
    Toast.makeText(this, "working connection to onRevertClick", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In onRevertclick");
  }

  public void loginUser(View view) {
    Toast.makeText(this, "working connection to loginUser", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In loginUser  ");
  }

  protected void onPause() {
    super.onPause();

    /* ----------- basic of Shared preferences -----------*/
    // create a share preference and a editor to work with that preference
    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
  }
}


