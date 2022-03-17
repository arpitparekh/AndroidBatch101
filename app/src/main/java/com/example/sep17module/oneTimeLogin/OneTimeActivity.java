package com.example.sep17module.oneTimeLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityOneTimeBinding;

public class OneTimeActivity extends AppCompatActivity {
    private ActivityOneTimeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOneTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkLogin();


        binding.Login.setOnClickListener(v -> {

            if(binding.edtEmail.getText().toString().equals("asdfgh") && binding.edtPass.getText().toString().equals("1234")){

                SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isLogin",true);
                editor.apply();
                startActivity(new Intent(this,DashBoardActivity.class));

            }

        });


    }

    void checkLogin(){

        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        boolean log = sp.getBoolean("isLogin",false);

        if(log){
            startActivity(new Intent(this,DashBoardActivity.class));
        }


    }
}