package com.example.jordanrburke.shelbycountyparksapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import butterknife.ButterKnife;


public class PoolSelectionFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pool_selection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static PoolSelectionFragment newInstance() {

        Bundle args = new Bundle();

        PoolSelectionFragment fragment = new PoolSelectionFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
