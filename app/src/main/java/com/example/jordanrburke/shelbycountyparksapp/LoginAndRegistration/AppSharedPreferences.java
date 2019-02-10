package com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {
    public static final String KEY_SAVE_BODY = "sms_body";
    public static final String PROFILE_EMAIL_KEY = "email_body";
    public static final String OCCUPATION_STATUS_KEY = "status_key";
    private static final String APP_SHARED_PREFS = AppSharedPreferences.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;

    public AppSharedPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this.preferencesEditor = sharedPreferences.edit();
    }

    public String getKeySaveBody() {
        return sharedPreferences.getString(KEY_SAVE_BODY, "");
    }

    public String getOccupationStatusKey() {
        return sharedPreferences.getString(OCCUPATION_STATUS_KEY, "");
    }

    public String getProfileEmailKey() {
        return sharedPreferences.getString(PROFILE_EMAIL_KEY,"");
    }

    public void saveStringBody(String text) {
        preferencesEditor.putString(KEY_SAVE_BODY, text);
        preferencesEditor.commit();
    }

    public void saveProfileEmailBody(String email) {
        preferencesEditor.putString(PROFILE_EMAIL_KEY, email);
        preferencesEditor.commit();
    }

    public void saveOccupationStatusKey(String status) {
        preferencesEditor.putString(OCCUPATION_STATUS_KEY, status);
        preferencesEditor.commit();

    }


}
