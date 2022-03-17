package com.example.sep17module.real_time_database_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityRealTimeDatabaseBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class RealTimeDatabaseActivity extends AppCompatActivity {
    private ActivityRealTimeDatabaseBinding binding;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRealTimeDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("messages");

          // write

        binding.btnFirebase.setOnClickListener(view -> {

            String data = binding.edtFirebase.getText().toString();

            ref.push().setValue(data);
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


        // read
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Toast.makeText(RealTimeDatabaseActivity.this, sna, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
}