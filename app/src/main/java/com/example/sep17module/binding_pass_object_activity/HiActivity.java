package com.example.sep17module.binding_pass_object_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sep17module.Deliver;
import com.example.sep17module.databinding.ActivityHiBinding;

public class HiActivity extends AppCompatActivity {

    private ActivityHiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();

        Deliver d = intent.getParcelableExtra("data");

        binding.textView.setText(d.toString());

    }
}