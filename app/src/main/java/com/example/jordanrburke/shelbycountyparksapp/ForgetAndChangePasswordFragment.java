package com.example.jordanrburke.shelbycountyparksapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetAndChangePasswordFragment extends Fragment {


    public ForgetAndChangePasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forget_and_change_password, container, false);
    }

    public static ForgetAndChangePasswordFragment newInstance() {

        Bundle args = new Bundle();

        ForgetAndChangePasswordFragment fragment = new ForgetAndChangePasswordFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
