package com.example.sep17module.radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.sep17module.databinding.ActivityRadioButtonBinding;
import com.google.android.material.snackbar.Snackbar;

public class RadioButtonActivity extends AppCompatActivity {
    private ActivityRadioButtonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRadioButtonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                String gender = "";
                if(binding.rbMale.isChecked()){

                    Snackbar.make(binding.relativeRadio,"Male is Selected",Snackbar.LENGTH_LONG).show();
                    binding.relativeRadio.setBackgroundColor(Color.rgb(0,153,0));
                    gender=binding.rbMale.getText().toString();
                }
                if(binding.rbFemale.isChecked()){
                    gender=binding.rbFemale.getText().toString();
                    Snackbar.make(binding.relativeRadio,"Female is Selected",Snackbar.LENGTH_LONG).show();
                    binding.relativeRadio.setBackgroundColor(Color.rgb(255,51,153));
                }

            }
        });


    }
}