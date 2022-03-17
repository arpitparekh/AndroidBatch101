package com.example.sep17module.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sep17module.databinding.ActivityMyServiceBinding;

public class MyServiceActivity extends AppCompatActivity {

    private ActivityMyServiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMusic.setOnClickListener(view -> {

            Intent i = new Intent(this,PlaySongService.class);
            startService(i);

        });

        binding.btnDownload.setOnClickListener(view -> {

            Intent i = new Intent(this,DownloadService.class);
            startService(i);

        });


    }
}