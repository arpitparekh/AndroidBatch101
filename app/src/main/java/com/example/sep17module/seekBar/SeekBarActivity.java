package com.example.sep17module.seekBar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;

import com.example.sep17module.databinding.ActivitySeekBarBinding;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ActivitySeekBarBinding binding;
    int red=0;
    int green=0;
    int blue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySeekBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.colorCode.setText("RED :"+red+" "+"GREEN : "+green+" "+"BLUE :"+blue);
        binding.ivMakeColor.setBackgroundColor(Color.rgb(red,green,blue));

        binding.sb1.setOnSeekBarChangeListener(this);
        binding.sb2.setOnSeekBarChangeListener(this);
        binding.sb3.setOnSeekBarChangeListener(this);

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        green =binding.sb2.getProgress();
        red = binding.sb1.getProgress();   // 0--255
        blue = binding.sb3.getProgress();

        binding.colorCode.setText("RED :"+red+" "+"GREEN : "+green+" "+"BLUE :"+blue);
        binding.ivMakeColor.setBackgroundColor(Color.rgb(red,green,blue));
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}