package com.example.sep17module.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.sep17module.databinding.ActivitySeekbarDemoBinding;

public class SeekbarDemoActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ActivitySeekbarDemoBinding binding;
    int red=0;
    int blue=0;
    int green=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySeekbarDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvColorCode.setText(red+" "+green+" "+blue);
        binding.constraintBackground.setBackgroundColor(Color.rgb(red,green,blue));

        binding.seekbar1.setOnSeekBarChangeListener(this);
        binding.seekbar2.setOnSeekBarChangeListener(this);
        binding.seekbar3.setOnSeekBarChangeListener(this);



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        red = binding.seekbar1.getProgress();
        green = binding.seekbar2.getProgress();
        blue = binding.seekbar3.getProgress();

        binding.tvColorCode.setText(red+" "+green+" "+blue);

        binding.constraintBackground.setBackgroundColor(Color.rgb(red,green,blue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}