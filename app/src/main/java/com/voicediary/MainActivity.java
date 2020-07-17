package com.voicediary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

    // we check here that the user is logged in , if not we run register


    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    if (user != null) {
      // User is signed in
      Toast.makeText(this, "User already signed.", Toast.LENGTH_SHORT).show();
    } else {
      // No user is signed in
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
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    if (user != null){
      /*user is signed in*/

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
    }
    else{
      Toast.makeText(this, "You must sign in to use the app, please sign inn. ", Toast.LENGTH_SHORT).show();
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

  /**
   * Register a new user in the system
   * @param view
   */
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

  /**
   * This method call the layout to reestablish a new password.
   * @param view
   */
  public void resetPassword(View view) {
    Toast.makeText(this, "working connection to resetPassword ", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In startRecording");

    Toast.makeText(this, "working connection to reset password", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In resetpassword");
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_view, new ResetPasswordFragment())

            .commit();


  }



  /**
   * This method is call by the button in the reset password layout and send an email to reset password.
   * @param view
   */
  public void resetUser( View view){
    UserAuthenticator newUser = new UserAuthenticator();
    newUser.reset(this);

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


  //This call to login is comming from the register screen ( fragment_register) in the beginning
  public void loginCall(View view) {
    Toast.makeText(this, "working connection to loginCall", Toast.LENGTH_SHORT).show();
    Log.d(TAG, "In loginCall");
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.main_view, new LoginFragment())

            .commit();




  }

  /**
   * Login the user in the app
   * create an UserAuthenticator object and use the method to login him from the class UserAuthenticator
   * @param view
   */
  public void loginUser(View view) {
    Toast.makeText(this, "working connection to login User", Toast.LENGTH_SHORT).show();

    UserAuthenticator newUser = new UserAuthenticator();
    newUser.loginUserAction(this);
    Log.d(TAG, "In loginUser  ");
  }

  protected void onPause() {
    super.onPause();

    /* ----------- basic of Shared preferences -----------*/
    // create a share preference and a editor to work with that preference
    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
  }
}


