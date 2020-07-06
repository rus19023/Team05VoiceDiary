package com.voicediary;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticator {

    /*create variables to hold user information*/
    private EditText userName;
    private EditText userMail;
    private EditText userPassword;
    private Button userRegistrationBtn;

    /*this came from the package firebase authentication */
    FirebaseAuth userFirebase;
    DatabaseReference usDatabase;

    /*register variables*/

    private String name = "";
    private String eMail = "";
    private String password = "";


    private static final String TAG = "UserAuthenticator class";


    public UserAuthenticator() {

        String name = "";
        String eMail = "";
        String password = "";
    }




    // Password authentication in firebase
    private boolean authenticateUser(MainActivity context) {
        Toast.makeText(context, "working connection to authenticateUser inside the class  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
        return true;
    }

    // create a new user in firebase
    public boolean createUser(final MainActivity context) {

        /*need it variables to work with firebase*/
        userFirebase = FirebaseAuth.getInstance();
        Toast.makeText(context, "working connection to createeUser inside the class  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In createUser  ");
        /*reference to the base node of firebase database*/
        usDatabase = FirebaseDatabase.getInstance().getReference();

        /*instantiate user information*/
        userName = (EditText) context.findViewById((R.id.userNameInput));
        userMail = (EditText) context.findViewById((R.id.emailInput));
        userPassword = (EditText) context.findViewById((R.id.password));
        userRegistrationBtn = (Button) context.findViewById((R.id.registerUser));

        userRegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*get information from the user*/
                name = userName.getText().toString();
                eMail = userMail.getText().toString();
                password = userPassword.getText().toString();

                /*control valid information and if valid perform register user method*/
                if (!name.isEmpty() && !eMail.isEmpty() && !password.isEmpty()) {

                    /*here is the call to register the user method*/
                    if (password.length() >= 6) {
                        registerUser(view);
                    } else {
                        Toast.makeText(context,
                                "Password must have at least 6 characters",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(context, "Must complette all fields", Toast.LENGTH_SHORT).show();
                }


            }
        });


        Toast.makeText(context, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
        return true;

    }


    /**
     * This Method register the user in firebase authentication
     */
    private void registerUser(final View view) {
        userFirebase.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    /*this map holds the information of the user to append to the database*/
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", eMail);
                    map.put("name", password);

                    /*this is the id created to the user in firebase authentication*/
                    String id = userFirebase.getCurrentUser().getUid();

                    /*create a new child in the database and append the user data plus send the register user to the open app to work*/
                    usDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                /*here we send the user to the activity or fragment to initiate the app and put finish to don't return here*/
                                Toast.makeText(view.getContext(), "succsesful login", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                } else {
                    Toast.makeText(view.getContext(), "User couldn't be register", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
