package com.example.sep17module.fragment_switching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.sep17module.R;

public class HolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);

        setTitle("My Activity");

        Fragment fragment=new FirstFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.holderFrameActivity,fragment)
                .commit();
    }
}