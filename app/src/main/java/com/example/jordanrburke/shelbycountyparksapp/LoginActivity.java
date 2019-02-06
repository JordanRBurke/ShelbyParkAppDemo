package com.example.jordanrburke.shelbycountyparksapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.forgot_password_button)
    protected Button forgotPasswordButton;
    @BindView(R.id.sign_in_button)
    protected Button SignButton;
    @BindView(R.id.login_register_button)
    protected Button RegisterButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth auth;
    private int loginAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
    }

    @OnClick(R.id.sign_in_button)
    protected void signInButtonClicked() {
        loginAttempts++;
        if (loginAttempts == 3) {
            forgotPasswordButton.setVisibility(View.VISIBLE);
        }
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();

        try {
            if (password.length() > 0 && email.length() > 0) {
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                            Log.v("error", task.getResult().toString());
                        } else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Text box can't be empty!", Toast.LENGTH_SHORT).show();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.login_register_button)
    protected void registrationButtonClicked() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.forgot_password_button)
    protected void forgotPasswordButtonClicked() {
        startActivity(new Intent(getApplicationContext(), ChangePasswordActivity.class).putExtra("Mode",0));
    }

    @Override
    protected void onResume() {

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        super.onResume();
    }
}
