package com.example.sep17module.pass_object_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMyHolderBinding;

public class MyHolderActivity extends AppCompatActivity {

    private ActivityMyHolderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("My Activity");
        binding=ActivityMyHolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment fragment=new KFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activityHolder,fragment)
                .commit();
    }
}