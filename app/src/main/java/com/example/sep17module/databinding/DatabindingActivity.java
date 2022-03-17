package com.example.sep17module.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.sep17module.R;
import com.example.sep17module.navigation_rail.NavigationFragment;

public class DatabindingActivity extends AppCompatActivity {

    private ActivityDatabindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDatabindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//
//        Data data =new Data("Ankit",242323,"ankit@gmail.com");
//
//        binding.setHi(data);
//
        Fragment fragment =new NavigationFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcv_goa,fragment)
                .commit();


    }
}