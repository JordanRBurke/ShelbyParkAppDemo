package com.example.jordanrburke.shelbycountyparksapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.jordanrburke.shelbycountyparksapp.LoginAndRegistration.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private ProfileEditFragment profileEditFragment;
    private PoolSelectionFragment poolSelectionFragment;

    private MenuItem profileButton;
    private MenuItem logInButton;




//    private TextView mTextMessage;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        profileButton = findViewById(R.id.profile_button_main);
        logInButton = findViewById(R.id.log_in_button_toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        poolSelectionFragment = new PoolSelectionFragment();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



//        if (user == null) {
//
//            profileButton.setVisible(false);
//
//        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_dashboard) {
                    setFragment(poolSelectionFragment);
//                    Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
//                    startActivity(intent);
                }
                return false;
            }
        });


//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
            Toast.makeText(this, "Please sign in....", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();

        }
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar_icons, menu);

        profileButton = menu.findItem(R.id.profile_button_main);
        profileButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                profileEditFragment = ProfileEditFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, profileEditFragment).commit();
                return true;
            }
        });
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_in_button_toolbar:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(this, "TEST", Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }


//    @OnClick(R.id.pools_button_main)
//    protected void poolSelectionPressed() {
//        poolSelectionFragment = PoolSelectionFragment.newInstance();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, poolSelectionFragment).commit();
//
//
//    }\

    @Override
    protected void onResume() {

        if (auth.getCurrentUser() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
