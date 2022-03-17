package com.example.sep17module;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityRatingBarBinding;

public class RatingBar extends AppCompatActivity {
    private ActivityRatingBarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRatingBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ratingBar.setOnRatingBarChangeListener(new android.widget.RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(android.widget.RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(RatingBar.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();

            }
        });

    }
}