package com.example.sep17module.patternLock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.databinding.ActivityMyPatternBinding;

public class MyPatternActivity extends AppCompatActivity {
    private ActivityMyPatternBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyPatternBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}