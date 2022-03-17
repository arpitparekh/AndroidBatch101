package com.example.sep17module.validateEmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityValidateBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateActivity extends AppCompatActivity {
    private ActivityValidateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityValidateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEnter.setOnClickListener(view -> {

            String email = binding.edtEmailPattern.getText().toString();

            // [a-zA-Z0-9._-]+@[a-z]+\.[a-z]+   // regex pattern

            Pattern pattern;
            Matcher matcher;

            pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+");

            matcher = pattern.matcher(email);

            new Handler().postDelayed(() -> {
                if(matcher.matches()){
                    Toast.makeText(ValidateActivity.this, "Valid Email", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ValidateActivity.this, "Email not Valid", Toast.LENGTH_SHORT).show();
                }
            },2000);
        });
    }
}