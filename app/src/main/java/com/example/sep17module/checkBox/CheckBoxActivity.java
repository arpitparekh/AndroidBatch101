package com.example.sep17module.checkBox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.sep17module.databinding.ActivityCheckBoxBinding;

public class CheckBoxActivity extends AppCompatActivity {
    private ActivityCheckBoxBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckBoxBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(binding.checkBox.isChecked()){

                    binding.imageView2.setVisibility(View.GONE);
                    binding.checkBox.setText("Show");
                    binding.toggleButton.setTextOn("Show");
                    binding.switch2.setText("Show");
                }
                else{
                    binding.imageView2.setVisibility(View.VISIBLE);

                }
            }
        });

        binding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(binding.toggleButton.isChecked()){

                    binding.imageView2.setVisibility(View.GONE);
                    binding.toggleButton.setTextOn("Show");
                }
                else{
                    binding.imageView2.setVisibility(View.VISIBLE);

                }
            }
        });

        binding.switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(binding.switch2.isChecked()){

                    binding.imageView2.setVisibility(View.GONE);
                    binding.switch2.setText("Show");
                }
                else{
                    binding.imageView2.setVisibility(View.VISIBLE);

                }
            }
        });



    }
}