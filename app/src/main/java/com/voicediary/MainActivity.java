package com.voicediary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Our Activity" ;
    String transcription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  /* ----------- basic of Shared preferences -----------

   create a share preference and a editor to work with that preference
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();


 create a new instance of intent to receive data from another activity
        Intent intent = getIntent();

  get the data send by the intent invoked
         book = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
         chapter = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
         verse = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
save the sharedPreferences values
        editor.putString(MainActivity.EXTRA_MESSAGE1 ,book);

        editor.putString(MainActivity.EXTRA_MESSAGE2 , chapter);

        editor.putString(MainActivity.EXTRA_MESSAGE3 , verse);

        // Why apply() and not commit() ?
        // See: http://stackoverflow.com/questions/5960678/whats-the-difference-between-commit-and-apply-in-shared-preference
        editor.apply();

retrieve the sharedPreferences values

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(R.integer.saved_high_score_default_key);
        int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue);







   */


    /*-------- this is the format of a basic intent-------
        remember that an intent is a connection between activities, then we must
        link this activity in which we are with the activity target
   example :
        Intent intent = new Intent(this, DisplayScriptureActivity.class);

        /taking information from this activity layout
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);

        /converting information to string
        String book = editText2.getText().toString();
        String chapter = editText3.getText().toString();
        String verse = editText4.getText().toString();

        /set in information in the new intent
        intent.putExtra(EXTRA_MESSAGE1, book);
        intent.putExtra(EXTRA_MESSAGE2, chapter);
        intent.putExtra(EXTRA_MESSAGE3, verse);

        / starting the new intent ( by this, we move to a new activity)
        startActivity(intent);


    */

    /* -------this is the format of a basic thread call-----
        // 1. Set up a new instance of our runnable object that will be run on the background thread

        GetAsyncTranscript getAsyncTranscript = new GetAsyncTranscript(this, voiceRecord);

       // 2. Set up the thread that will use our runnable object

        Thread t = new Thread(getAsyncTranscript);

        // 3. starts the thread in the background. It will automatically call the run method of
        // the getAsyncTranscript object we gave it earlier

        t.start();

     */


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






    // Password authentication in firebase

    private authenticateUser(){
        Toast.makeText(this, "working conection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
    }

    // create a new user in firebase
    private createUser(){
        Toast.makeText(this, "working conection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");

    }

    // record sound from the device using media
    public startRecording() {
        Toast.makeText(this, "working conection to startRecording ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In startRecording  ");
    }


    // stop the recording from the device
    public stopRecording(){
        Toast.makeText(this, "working conection to stopRecording", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   stopRecording");
    }



    // request transcription from the API
    public requestTranscription(){
        Toast.makeText(this, "working conection to requestTranscription", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  requestTranscription");
    }

    // show transcription received
    public seeTranscription(){
        Toast.makeText(this, "working conection to seeTranscription ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  seeTranscription ");
    }


    // store the new text entry received (shared preferences or firebase)
    public saveNewEntry(){
        Toast.makeText(this, "working conection to  saveNewEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   ");
    }

    // delete an entry from storage
    public deleteSavedEntry(){
        Toast.makeText(this, "working conection to deleteSavedEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  saveNewEntry ");
    }


    // search and retrieve an entry from storage
    public retrieveEntry(){
        Toast.makeText(this, "working conection to retrieveEntry ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  retrieveEntry ");
    }

    // receive text from the API as json and put it in a string
    public receiveText(){
        Toast.makeText(this, "working conection to  receiveText", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In receiveText  ");
    }


}