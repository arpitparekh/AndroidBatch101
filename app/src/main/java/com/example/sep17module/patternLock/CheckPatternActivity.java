package com.example.sep17module.patternLock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityCheckPatternBinding;
import com.example.sep17module.room_sql_internal_database.MySqlActivity;

import java.util.List;

public class CheckPatternActivity extends AppCompatActivity {
    private ActivityCheckPatternBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckPatternBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sp = getSharedPreferences("pattern",MODE_PRIVATE);
        String data = sp.getString("myPattern"," ");

        binding.patternLockViewCheck.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if(data.equals(PatternLockUtils.patternToString(binding.patternLockViewCheck,pattern))){
                    startActivity(new Intent(CheckPatternActivity.this, MyPatternActivity.class));
                }else{
                    Toast.makeText(CheckPatternActivity.this, "Pattern is Wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCleared() {

            }
        });
    }
}