package com.voicediary;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class StorageDelete implements Runnable {
    private static final String TAG = "Storage" ;

    public Uri getFilePath() {
        return filePath;
    }

    public void setFilePath(Uri filePath) {
        this.filePath = filePath;
    }

    private Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance();
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
        deleteSavedEntry();
    }

    // delete an entry from storage
    public boolean deleteSavedEntry() {
        StorageReference storageRef = storage.getReference();
        StorageReference fileRef = storageRef.child(String.valueOf(filePath));
        fileRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // File deleted successfully
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Uh-oh, an error occurred!
            }
        });
        Toast.makeText(context, "working connection to StorageDelete", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  saveNewEntry");
        return true;
    }
}
