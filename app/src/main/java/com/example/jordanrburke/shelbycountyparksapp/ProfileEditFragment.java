package com.example.jordanrburke.shelbycountyparksapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentResolver;

import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.AppSharedPreferences;
import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.LoginActivity;
import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileEditFragment extends Fragment {

    @BindView(R.id.log_out_profile_button)
    protected Button logOutButton;
    @BindView(R.id.change_profile_pic_button)
    protected Button changeProfileButton;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private Profile profile;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView statusTextView;
    private AppSharedPreferences appSharedPreferences;
    private SharedPreferences.Editor editor;
    public static final int GET_FROM_GALLERY = 3;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_edit, container, false);
        ButterKnife.bind(this, view);
        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        appSharedPreferences = new AppSharedPreferences(Objects.requireNonNull(getContext()));

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() == null) {
            Toast.makeText(getContext(), "No User Detected", Toast.LENGTH_SHORT).show();
        } else {
            nameTextView = getView().findViewById(R.id.profile_name_text);
            emailTextView = getView().findViewById(R.id.profile_email_text);
            statusTextView = getView().findViewById(R.id.profile_occupation_text);
            nameTextView.setText(appSharedPreferences.getKeySaveBody());
            emailTextView.setText(appSharedPreferences.getProfileEmailKey());
            statusTextView.setText(appSharedPreferences.getOccupationStatusKey());
            if (appSharedPreferences.getOccupationStatusKey().equals("Lifeguard")) {
                statusTextView.setBackgroundColor(getResources().getColor(R.color.red));
                statusTextView.setTextColor(getResources().getColor(R.color.white));
            } else if (appSharedPreferences.getOccupationStatusKey().equals("Swimmer")) {
                statusTextView.setBackgroundColor(getResources().getColor(R.color.blue));
                statusTextView.setTextColor(getResources().getColor(R.color.white));
            } else if (appSharedPreferences.getOccupationStatusKey().equals("Swim Instructor")) {
                statusTextView.setBackgroundColor(getResources().getColor(R.color.swimInstructorColor));
                statusTextView.setTextColor(getResources().getColor(R.color.white));
            } else if (appSharedPreferences.getOccupationStatusKey().equals("Other Staff")) {
                statusTextView.setBackgroundColor(getResources().getColor(R.color.green));
                statusTextView.setText("Other Staff");
            } else {
                statusTextView.setText("");
            }
//            nameTextView.setText(profile.getRegisteredName());
//            emailTextView.setText(profile.getRegisteredEmail());

        }



    }

    @OnClick(R.id.change_profile_pic_button)
    protected void changeProfileClicked() {
        startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            changeProfileButton.setBackground(selectedImage);

        }
    }

    public static ProfileEditFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ProfileEditFragment fragment = new ProfileEditFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.log_out_profile_button)
    protected void logOutPressed() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);

    }


    private void profileLoadInfo() {


//        if (profile.getRegisteredName() == null || profile.getRegisteredEmail() == null) {
//
//        } else {
//            nameTextView.setText(profile.getRegisteredName());
//            emailTextView.setText(profile.getRegisteredEmail());
//        }


    }



}
