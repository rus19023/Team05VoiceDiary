package com.voicediary;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    // variables
    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context context;

    private static final String IS_LOGIN = "isLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public SessionManager(Context _context) {
        context = _context;
        userSession = context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE );
        editor = userSession.edit();
    }

    public void createLoginSession(String isLoggedIn, String username, String password) {

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public HashMap<String, String> getUserDetailFromSession() {
        HashMap<String, String> userData = new HashMap<>();
        userData.put(KEY_USERNAME, userSession.getString(KEY_USERNAME, null));
        userData.put(KEY_PASSWORD, userSession.getString(KEY_PASSWORD, null));
        userData.put(KEY_USERNAME, userSession.getString(KEY_USERNAME, null));

        return userData;
    }

    public boolean checkLogin() {
        if(userSession.getBoolean(IS_LOGIN, true)) {
            return true;
        } else {
            return false;
        }
    }

    public void logoutUserFromSession() {
        editor.clear();
        editor.apply();
    }
}
