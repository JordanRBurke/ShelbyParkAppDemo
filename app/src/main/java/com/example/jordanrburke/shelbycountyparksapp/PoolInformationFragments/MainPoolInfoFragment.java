package com.example.jordanrburke.shelbycountyparksapp.PoolInformationFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jordanrburke.shelbycountyparksapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPoolInfoFragment extends Fragment {


    public MainPoolInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_pool_info, container, false);
    }

    public static MainPoolInfoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MainPoolInfoFragment fragment = new MainPoolInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
