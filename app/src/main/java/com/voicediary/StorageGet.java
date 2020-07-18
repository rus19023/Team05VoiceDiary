package com.voicediary;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class StorageGet implements Runnable {
    private static final String TAG = "Storage" ;
    private StorageReference storageReference;

    public Uri getFilePath() {
        return filePath;
    }

    public void setFilePath(Uri filePath) {
        this.filePath = filePath;
    }

    Uri filePath;
    MainActivity context;
    FirebaseStorage storage = FirebaseStorage.getInstance();

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
        getEntry();
    }
    // store the new text entry received (shared preferences or firebase)
    public boolean getEntry() {
        StorageReference storageRef = storage.getReference();
        StorageReference getRef = storage.getReferenceFromUrl(String.valueOf(filePath));

        File localFile = null;
        try {
            localFile = File.createTempFile("placeholder", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        getRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

        Toast.makeText(context, "working connection to StorageGet", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   ");
        return true;
    }
}
