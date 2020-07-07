package com.voicediary;

import android.util.Log;
import android.widget.Toast;

public class StorageDelete implements Runnable {
    private static final String TAG = "Storage" ;
    private String text;
    MainActivity context;

    @Override
    public void run() {

        // We are creating a simple loop which will run and allow us to take
        // a look into how the different threads run.
        for (int i = 0; i < 100; i += 2) {

            // Thread.currentThread().getName() is used to get the name of the
            // currently running thread. We can provide a name, if we create
            // the thread ourselves, else it will be given one from the JVM.
            System.out.println(Thread.currentThread().getName() +
                    "\twith Runnable: counting by evens" + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // delete an entry from storage
    public boolean deleteSavedEntry() {
        Toast.makeText(context, "working conection to deleteSavedEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  saveNewEntry ");
        return true;
    }
}
