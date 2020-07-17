package com.voicediary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

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


  /* ---------this is one of the ways we can implement the thread that respond to the call-------
   @Override
  public void run() {
      // This is the function that will be run on the background thread.

      VoiceTranscriptionLoader loader = new VoiceTranscriptionLoader();

      // Now, call the function that will get the results from the API and then when it is done,
      // it will call the "handleResult" function on this new WeatherConditionsResultHandler
      // object that we are giving it.
      loader.getTranscription(voiceRecord, new VoiceTranscription() {
          @Override
          public void handleResult(VoiceTranscription voiceText) {

              // At this point we will be back from the API with the results stored in `voiceText`

              // Next, we need to run the function that will update the UI elements, but this
              // must be run on the UI thread

              activity.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      // This is code that will now run on the UI thread. Call the function in
                      // MainActivity that will update the UI correctly.
                      activity.receiveText(voiceText);
                  }
   */

  // show transcription received
  public String seeTranscription() {
    Toast.makeText(this, "working connection to seeTranscription ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In  seeTranscription ");
    return transcription;
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.nav_record:
        Button start = null;
        getSupportFragmentManager()
            .beginTransaction()
              .replace(R.id.main_view, new RecordingFragment() {
                @Override
                public void onClick(View view) {

                }
              })
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
        break;
      case R.id.nav_logout:
        Toast.makeText(this, "This menu item will connect to Logout", Toast.LENGTH_SHORT).show();
        break;
    }
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
    Log.d(TAG, "In authenticateUser");
  }

  public void pauseRecording(View view) {
    Toast.makeText(this, "working connection to pauseRecording  ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In pauseRecording");
  }

  public void startToRecord(View view) {
    Toast.makeText(this, "working connection to startRecording ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In startToRecord");
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
    Toast.makeText(this, "working connection to saveNewEntry", Toast.LENGTH_SHORT).show();
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


