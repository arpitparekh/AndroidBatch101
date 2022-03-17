package com.example.sep17module.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMyAnimationBinding;

public class MyAnimationActivity extends AppCompatActivity {

    private ActivityMyAnimationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyAnimationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBlink.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
            binding.ivAnim.startAnimation(animation);

        });

        binding.btnZoom.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale_anim);
            binding.ivAnim.startAnimation(animation);
        });

        binding.btnSlide.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate_anim);
            binding.ivAnim.startAnimation(animation);

        });

        binding.btnRotate.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
            binding.ivAnim.startAnimation(animation);

        });

    }
}