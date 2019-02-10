package com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.jordanrburke.shelbycountyparksapp.MainActivity;
import com.example.jordanrburke.shelbycountyparksapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.email_edit_register)
    protected EditText emailRegisterText;
    @BindView(R.id.name_edit_register)
    protected EditText nameRegisterText;
    @BindView(R.id.password_edit_register)
    protected EditText passwordRegisterText;
    @BindView(R.id.register_button_register)
    protected Button registerButton;
    private Profile profile;
    private FirebaseAuth auth;
    private AppSharedPreferences appSharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean switchStatusLifeguard;
    private boolean switchStatusSwimmer;
    private boolean switchStatusInstructor;
    private boolean switchStatusOtherStaff;
    private Switch lifeguardSwitch;
    private Switch swimmerSwitch;
    private Switch swimInstructor;
    private Switch otherStaff;
    private String switchStatusText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        lifeguardSwitch = findViewById(R.id.switch_lifeguard);
        swimmerSwitch = findViewById(R.id.switch_swimmer);
        swimInstructor = findViewById(R.id.switch_swim_instructor);
        otherStaff = findViewById(R.id.other_staff_switch);

        appSharedPreferences = new AppSharedPreferences(getApplicationContext());

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }

    }

    @OnClick(R.id.register_button_register)
    protected void registerButtonClicked() {
        final String email = emailRegisterText.getText().toString();
        final String password = passwordRegisterText.getText().toString();
        final String name = nameRegisterText.getText().toString();
        if (lifeguardSwitch.isChecked()) {
            switchStatusText = "Lifeguard";
        } else if (swimmerSwitch.isChecked()){
            switchStatusText = "Swimmer";
        } else if (swimInstructor.isChecked()) {
            switchStatusText = "Swim Instructor";
        } else if (otherStaff.isChecked()) {
            switchStatusText = "Other Staff";
        } else {

        }
        profile = new Profile(email, name, switchStatusText);
        profile.setRegisteredName(name);
        profile.setRegisteredEmail(email);
        profile.setRegisteredStatus(switchStatusText);
        appSharedPreferences.saveStringBody(name);
        appSharedPreferences.saveProfileEmailBody(email);
        appSharedPreferences.saveOccupationStatusKey(switchStatusText);



        try {
            if (password.length() > 0 && email.length() > 0) {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                    Log.v("error", task.getResult().toString());

                                } else {
                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            } else {
                Toast.makeText(this, "Fill All Fields", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void profileDataMethod() {

    }
}
