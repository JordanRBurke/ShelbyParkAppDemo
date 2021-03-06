package com.example.jordanrburke.shelbycountyparksapp;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
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
import java.security.Permission;
import java.security.Permissions;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;


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
    private ImageView profilePicture;
    public static final int GET_FROM_GALLERY = 3;
    private String[] galleryPermissions = {Manifest.permission.
            READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};





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

        BottomNavigationView bottomNavigationView = getView().findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_dashboard) {


                } else if (id == R.id.navigation_home) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        if (EasyPermissions.hasPermissions(getContext(), galleryPermissions)) {

        } else {
            EasyPermissions.requestPermissions(getContext(), "Access for storage",
                    101, galleryPermissions);
        }

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

        }



    }

    private void setFragment(Fragment fragment) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.main_frame_layout, fragment);
//        fragmentTransaction.commit();

    }

    @OnClick(R.id.change_profile_pic_button)
    protected void changeProfileClicked() {
        startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContext().getContentResolver().query(selectedImage, filePathColumn,
                    null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

//            Bitmap bitmap = null;
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            profilePicture = getView().findViewById(R.id.profile_pic_user_choice);
            profilePicture.setImageBitmap(BitmapFactory.decodeFile(picturePath));






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
