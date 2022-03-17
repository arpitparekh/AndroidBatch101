package com.example.sep17module.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityCustomToastBinding;
import com.example.sep17module.databinding.CustomToastBinding;

public class CustomToastActivity extends AppCompatActivity {
    private ActivityCustomToastBinding binding;
    private CustomToastBinding binding1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCustomToastBinding.inflate(getLayoutInflater());
        binding1=CustomToastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.extendedFloatingActionButton.shrink();

        binding.extendedFloatingActionButton.setOnClickListener(view -> {

            if(binding.extendedFloatingActionButton.isExtended()){
                binding.extendedFloatingActionButton.shrink();
            }else{
                binding.extendedFloatingActionButton.extend();

            }

            Toast toast =new Toast(this);

            toast.setGravity(Gravity.TOP,0,300);

            toast.setView(binding1.getRoot());

            toast.setDuration(Toast.LENGTH_LONG);

            binding1.tvToast.setText("This is my Toast");

            toast.show();




        });


    }
}