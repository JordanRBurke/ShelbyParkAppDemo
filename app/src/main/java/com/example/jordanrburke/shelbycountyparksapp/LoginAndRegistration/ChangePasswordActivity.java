package com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jordanrburke.shelbycountyparksapp.R;

import butterknife.ButterKnife;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
    }
}
