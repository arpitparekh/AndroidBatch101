package com.example.sep17module.crud_operation_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityFirebaseHostBinding;

public class FirebaseHostActivity extends AppCompatActivity {
    private ActivityFirebaseHostBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFirebaseHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.firebaseHost,new ShowFirebaseDataFragment())
                .commit();


    }
}