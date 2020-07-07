package com.voicediary;

import android.util.Log;
import android.widget.Toast;

public class StorageGet implements Runnable {
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
        // store the new text entry received (shared preferences or firebase)
        public boolean saveNewEntry() {

            Toast.makeText(context, "working conection to  saveNewEntry", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "In   ");
            return true;
        }
    }






