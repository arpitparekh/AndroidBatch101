package com.example.sep17module.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sep17module.dialog.MyDialogActivity;
import com.example.sep17module.databinding.ActivitySplashScreenDemoBinding;

public class SplashScreenDemoActivity extends AppCompatActivity {
    private ActivitySplashScreenDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashScreenDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Handler Class

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreenDemoActivity.this, MyDialogActivity.class);
                startActivity(intent);

                finish();  // only open once


            }
        },4000);
    }
}