package com.example.sep17module;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.sep17module.databinding.ActivityCustomAssistButtonBinding;

public class CustomAssistButtonActivity extends AppCompatActivity {

    private ActivityCustomAssistButtonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCustomAssistButtonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.floatingActionButton3.setVisibility(View.GONE);
        binding.floatingActionButton4.setVisibility(View.GONE);
        binding.floatingActionButton5.setVisibility(View.GONE);
        binding.floatingActionButton2.setVisibility(View.VISIBLE);

        binding.floatingActionButton2.setOnClickListener(view -> {
            binding.floatingActionButton3.setVisibility(View.VISIBLE);
            binding.floatingActionButton4.setVisibility(View.VISIBLE);
            binding.floatingActionButton5.setVisibility(View.VISIBLE);
        });
    }
}