package com.example.jordanrburke.shelbycountyparksapp.PoolStatusFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jordanrburke.shelbycountyparksapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutsidePoolStatusFragment extends Fragment {


    public OutsidePoolStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outside_pool_status, container, false);
    }

    public static OutsidePoolStatusFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OutsidePoolStatusFragment fragment = new OutsidePoolStatusFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
