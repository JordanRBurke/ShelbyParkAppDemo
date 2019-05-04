package com.example.jordanrburke.shelbycountyparksapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BabyPoolInfoFragment extends Fragment {


    public BabyPoolInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_baby_pool_info, container, false);
        return view;
    }

    public static BabyPoolInfoFragment newInstance() {

        Bundle args = new Bundle();

        BabyPoolInfoFragment fragment = new BabyPoolInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
