package com.example.jordanrburke.shelbycountyparksapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileEditFragment extends Fragment {


    public ProfileEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }

    public static ProfileEditFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ProfileEditFragment fragment = new ProfileEditFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
