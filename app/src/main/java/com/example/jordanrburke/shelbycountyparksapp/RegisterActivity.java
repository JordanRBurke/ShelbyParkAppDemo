package com.example.jordanrburke.shelbycountyparksapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.email_edit_register)
    protected EditText emailRegisterText;
    @BindView(R.id.name_edit_register)
    protected EditText nameRegisterText;
    @BindView(R.id.password_edit_register)
    protected EditText passwordRegisterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}
