package com.example.sep17module.bottom_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.databinding.ActivityBottomSheetBinding;

public class BottomSheetActivity extends AppCompatActivity {
    private ActivityBottomSheetBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBottomSheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBottomSheet.setOnClickListener(v -> {

            ActionBottomSheetFragment fragment =new ActionBottomSheetFragment();
            fragment.show(getSupportFragmentManager(),"sheet");

        });
    }
}