package com.example.sep17module.retrofit_local_server_xampp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.R;

public class RetrofitHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_host);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.retrofitHost,new StudentListFragment())
                .commit();
    }
}