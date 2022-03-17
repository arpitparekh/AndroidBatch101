package com.example.sep17module.authentication_firebase_cloud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.R;

public class MyLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcv_firebase,new NewLoginFragment())
                .commit();
    }
}