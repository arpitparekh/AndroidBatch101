package com.example.sep17module.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.R;

public class MyMvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mvvm);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.linearLayout,new F1Fragment())
                .add(R.id.linearLayout,new F2Fragment())
                .commit();
    }
}