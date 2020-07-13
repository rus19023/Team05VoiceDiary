package com.voicediary;

import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static androidx.core.content.ContextCompat.startActivity;

public class UserAuthenticator {

    /*create variables to hold user information*/
    private EditText userName;
    private EditText userMail;
    private EditText userPassword;


    private DrawerLayout drawer;

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


    // create a new user in firebase
    public boolean createUser(final MainActivity context) {

        /*need it variables to work with firebase*/
        userFirebase = FirebaseAuth.getInstance();
        Toast.makeText(context, "working connection to createe User inside the class  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In createUser  ");
        /*reference to the base node of firebase database*/
        usDatabase = FirebaseDatabase.getInstance().getReference();

        /*instantiate user information*/
        userName = (EditText) context.findViewById((R.id.userNameInput));
        userMail = (EditText) context.findViewById((R.id.emailInput));
        userPassword = (EditText) context.findViewById((R.id.password));
        Button userRegistrationBtn = (Button) context.findViewById((R.id.registerUser));



        /*get information from the user*/
        name = userName.getText().toString();
        eMail = userMail.getText().toString();
        password = userPassword.getText().toString();

        /*control valid information and if valid perform register user method*/
        if (!name.isEmpty() && !eMail.isEmpty() && !password.isEmpty()) {

            /*here is the call to register the user method*/
            if (password.length() >= 6) {
                registerUser(context);
            } else {
                Toast.makeText(context,
                        "Password must have at least 6 characters",
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(context, "Must complette all fields", Toast.LENGTH_SHORT).show();
        }


        Toast.makeText(context, "working connection to authenticateUser  ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In authenticateUser  ");
        return true;

    }


    /**
     * This Method register the user in firebase authentication
     */

    /**
     * Create a new user in Firebase Authenticator, receiving name, email and password  from the view
     * Register the new user in firebase realtime database
     *
     * @param context return Void
     */
    private void registerUser(final MainActivity context) {
        userFirebase.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    /*this map holds the information of the user to append to the database*/
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", eMail);
                    map.put("password", password);

                    /*this is the id created to the user in firebase authentication*/
                    String id = userFirebase.getCurrentUser().getUid();

                    /*create a new child in the database and append the user data plus send the register user to the open app to work*/
                    usDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                /*here we send the user to the activity or fragment to initiate the app and put finish to don't return here*/
                                Toast.makeText(context, "succsesful login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(context, MainActivity.class);
                                startActivity(context, intent, null);
                                context.finish();
                            }
                        }
                    });


                } else {
                    Toast.makeText(context, "User couldn't be register", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void loginUserAction(MainActivity context) {

            /*get the information from the user*/
       userMail = (EditText) context.findViewById((R.id.email));
        userPassword = (EditText) context.findViewById((R.id.password));


        eMail = userMail.getText().toString();
        password = userPassword.getText().toString();
        if (!eMail.isEmpty() && (!password.isEmpty())) {
                login(eMail, password, context);
        }
        else{
            Toast.makeText(context, "Must complete all fields.", Toast.LENGTH_SHORT).show();
        }
    }



    private void login(String eMail, String password, final MainActivity context) {
        userFirebase = FirebaseAuth.getInstance();
        userFirebase.signInWithEmailAndPassword(eMail, password).addOnCompleteListener
                (new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(context, intent, null);
                            Toast.makeText(context, "SUCCSESS LOGIN", Toast.LENGTH_SHORT).show();
                            context.finish();
                        }
                        else{
                            Toast.makeText(context, "Couldn't start session, must review your input.", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );
    }

    /**
     * logOutUser method take an user and log out from the firebase authentication system
     * @param context
     */

    public void logOutUser(MainActivity context) {

        /* get an instance of the firebase class*/
        userFirebase = FirebaseAuth.getInstance();

        /*apply the method signout from the FirebaseAuth class to my object*/
        userFirebase.signOut();
        Toast.makeText(context, "SUCCESS LOGOUT", Toast.LENGTH_SHORT).show();
        /*back to Main Activity*/
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context, intent, null);
        context.finish();


    }
}

