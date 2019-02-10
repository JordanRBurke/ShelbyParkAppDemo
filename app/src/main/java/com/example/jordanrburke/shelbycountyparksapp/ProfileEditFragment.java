package com.example.jordanrburke.shelbycountyparksapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.LoginActivity;
import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileEditFragment extends Fragment {

    @BindView(R.id.log_out_profile_button)
    protected Button logOutButton;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private Profile profile;
    private TextView nameTextView;
    private TextView emailTextView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_edit, container, false);
        ButterKnife.bind(this, view);
        return view;


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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nameTextView.setId(R.id.profile_name_text);
        emailTextView.setId(R.id.profile_email_text);

        nameTextView.setText("");
        emailTextView.setText("");

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
