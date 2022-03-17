package com.example.sep17module.chips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityChipsBinding;
import com.google.android.material.chip.ChipGroup;

public class ChipsActivity extends AppCompatActivity {
    private ActivityChipsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChipsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.chipHiking.setOnClickListener(view -> {
            if(binding.chipHiking.isChecked()){
                binding.chipHiking.setChipBackgroundColor(ColorStateList.valueOf(Color.GREEN));
            }else{
                binding.chipHiking.setChipBackgroundColor(ColorStateList.valueOf(Color.LTGRAY));
            }
        });


        binding.button3.setOnClickListener(view -> {

            String hobby="";
            if(binding.chipHiking.isChecked()){
                hobby=hobby+binding.chipHiking.getText().toString();
            }
            if(binding.chipCycling.isChecked()){
                hobby=hobby+binding.chipCycling.getText().toString();
            }
            if(binding.chipBiking.isChecked()){
                hobby=hobby+binding.chipBiking.getText().toString();
            }
            if(binding.chipYoga.isChecked()){
                hobby=hobby+binding.chipYoga.getText().toString();
            }

            Toast.makeText(this, hobby, Toast.LENGTH_SHORT).show();
        });
    }

}