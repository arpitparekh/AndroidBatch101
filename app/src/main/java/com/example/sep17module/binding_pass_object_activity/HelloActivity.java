package com.example.sep17module.binding_pass_object_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sep17module.Deliver;
import com.example.sep17module.databinding.ActivityHelloBinding;

public class HelloActivity extends AppCompatActivity {

    private ActivityHelloBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Deliver d = new Deliver("Car",1000000);

        binding.floatingActionButton.setOnClickListener(view -> {

            Intent intent=new Intent(this,HiActivity.class);
            intent.putExtra("data",d);
            startActivity(intent);
        });


    }
}