package com.example.sep17module.checkBox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityCheckBoxNewBinding;

public class CheckBoxNewActivity extends AppCompatActivity{
    private ActivityCheckBoxNewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckBoxNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button2.setOnClickListener(view -> {
            String data = makeString();
        });

    }

    private String makeString(){

        String hobby="";
        if(binding.checkBox2.isChecked()){
            hobby=hobby+" "+binding.checkBox2.getText().toString();
        }
        if(binding.checkBox3.isChecked()){
            hobby=hobby+" "+binding.checkBox3.getText().toString();
        }
        if(binding.checkBox4.isChecked()){
            hobby=hobby+" "+binding.checkBox4.getText().toString();
        }
        if(binding.checkBox5.isChecked()){
            hobby=hobby+" "+binding.checkBox5.getText().toString();
        }
        Toast.makeText(this, hobby, Toast.LENGTH_SHORT).show();
        return hobby;



    }
}