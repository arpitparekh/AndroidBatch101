package com.example.sep17module.passObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityAnotherHolderBinding;

public class AnotherHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_holder);


        // no ActionBar
        //        getSupportActionBar().hide();

        //no title bar

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Fragment f=new MeraFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.AnotherHolder,f)
                .commit();
    }
}