package com.example.sep17module.login_register_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.R;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,new LoginFragment())
                .commit();

    }
}