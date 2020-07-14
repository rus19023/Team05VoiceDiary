package com.voicediary;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.*;

import java.util.HashMap;
import java.util.Map;


public class StorageSave implements Runnable {
    FirebaseFirestore db;
    private static final String TAG = "Storage" ;
    private String fileName;
    private StorageReference storageReference;
    private Uri filePath;
    private String uid;
    MainActivity context;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Uri getFilePath() {
        return filePath;
    }

    public void setFilePath(Uri filePath) {
        this.filePath = filePath;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public void run() {
        storageReference = FirebaseStorage.getInstance().getReference();
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
        saveNewEntry();
    }






    // store the new text entry received (shared preferences or firebase)
    public boolean saveNewEntry() {
        db = FirebaseFirestore.getInstance();
        // Where the file will be stored
        final StorageReference storageRef = storageReference.child(String.valueOf(filePath));

        // What file is to be stored
        storageRef.putFile(filePath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Uri downloadUrl = uri;
                                Toast.makeText(context, "Upload Done", Toast.LENGTH_LONG).show();
                                //After upload Complete we have to store the Data to firestore.
                                Map<String, Object> file = new HashMap<>();
                                file.put("url", downloadUrl.toString()); // We are using it as String because our data type in Firestore will be String
                                db.collection(uid).document(fileName)
                                        .set(file)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error writing document", e);
                                            }
                                        });
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(context, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        Toast.makeText(context, "working connection to saveNewEntry", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In   ");
        return true;
    }
}
