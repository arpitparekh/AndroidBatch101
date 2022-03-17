package com.example.sep17module.patternLock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.sep17module.databinding.ActivityInsertPatternBinding;

import java.util.List;

public class InsertPatternActivity extends AppCompatActivity {
    private ActivityInsertPatternBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInsertPatternBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sp = getSharedPreferences("pattern",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        binding.patternLockViewInsert.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {

                editor.putString("myPattern",PatternLockUtils.patternToString(binding.patternLockViewInsert,pattern));
                editor.apply();

                startActivity(new Intent(InsertPatternActivity.this,CheckPatternActivity.class));
            }

            @Override
            public void onCleared() {

            }
        });
    }
}