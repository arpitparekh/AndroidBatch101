package com.example.sep17module.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityMyStorageBinding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyStorageActivity extends AppCompatActivity {
    private ActivityMyStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSaveInternal.setOnClickListener(v -> {

            String data = binding.edtStoreString.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("hello.txt",MODE_PRIVATE);
                // fos sends data only in bytes
                fos.write(data.getBytes());
                fos.flush();
                fos.close();

                Toast.makeText(MyStorageActivity.this, "Data Store SuccessFully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        binding.btnGetInternal.setOnClickListener(v -> {

            try {

                FileInputStream fis = openFileInput("hello.txt");
                byte arr[]=new byte[fis.available()];
                fis.read(arr);
                String newData = new String(arr);

                binding.showData.setText(newData);



            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        binding.storeSharedPref.setOnClickListener(v -> {

            String name = binding.edtStoreString.getText().toString();

            SharedPreferences sp = getSharedPreferences("demoPref",MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("key1",name);
            editor.putString("key2","myValue");
            editor.apply();

            Toast.makeText(MyStorageActivity.this, "Data Stored in Shred Preference", Toast.LENGTH_SHORT).show();


        });

        binding.button11.setOnClickListener(v -> {

            SharedPreferences sp1 = getSharedPreferences("demoPref",MODE_PRIVATE);
            String newName = sp1.getString("key1"," ");
            String newname2 = sp1.getString("key2","");

            binding.showData.setText(newName +" "+newname2);

        });
    }
}