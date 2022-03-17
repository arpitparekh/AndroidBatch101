package com.example.sep17module.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityMyPermissionBinding;
import com.example.sep17module.databinding.ActivityMySqlBinding;
import com.example.sep17module.picker.DataPickerActivity;

public class MyPermissionActivity extends AppCompatActivity {
    private ActivityMyPermissionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnETR.setOnClickListener(view -> {

            checkMyPermission(Manifest.permission.READ_EXTERNAL_STORAGE,101);

        });
        binding.btnETW.setOnClickListener(view -> {

            checkMyPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,102);
        });
        binding.btnCall.setOnClickListener(view -> {

            checkMyPermission(Manifest.permission.CALL_PHONE,103);
        });
        binding.btnCam.setOnClickListener(view -> {

            checkMyPermission(Manifest.permission.CAMERA,104);
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this,"Permission granted",Toast.LENGTH_LONG).show();

                Intent i = new Intent(this, DataPickerActivity.class);
                startActivity(i);

            }else{

                Toast.makeText(this,"Permission apne bhai",Toast.LENGTH_LONG).show();
            }

        }

    }
    void checkMyPermission(String permissionNew,int code){

        String[] permission = {permissionNew};

        if(ContextCompat.checkSelfPermission(this, permissionNew) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,permission,code);

        }
    }
}