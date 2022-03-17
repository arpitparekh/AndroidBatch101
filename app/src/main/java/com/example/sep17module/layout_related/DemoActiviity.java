package com.example.sep17module.layout_related;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityDemoActiviityBinding;
import com.google.android.material.snackbar.Snackbar;

public class DemoActiviity extends AppCompatActivity {

    private ActivityDemoActiviityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDemoActiviityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.fb.setOnClickListener(view -> {

            //Toast
//            Toast.makeText(this,"This is my Toast",Toast.LENGTH_LONG).show();

            //snack bar
            Snackbar.make(view,"This is my Snackbar",Snackbar.LENGTH_LONG).show();

        });
    }
}