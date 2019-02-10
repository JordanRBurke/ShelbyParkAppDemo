package com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration;

import android.widget.ImageView;

public class Profile {

    private String registeredEmail;
    private String registeredName;
    private String registeredStatus;
    private ImageView profilePicture;

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getRegisteredStatus() {
        return registeredStatus;
    }

    public void setRegisteredStatus(String registeredStatus) {
        this.registeredStatus = registeredStatus;
    }

    public ImageView getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ImageView profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Profile(String registeredEmail, String registeredName, String registeredStatus, ImageView profilePicture) {
        this.registeredEmail = registeredEmail;
        this.registeredName = registeredName;
        this.registeredStatus = registeredStatus;
        this.profilePicture = profilePicture;
    }
}
