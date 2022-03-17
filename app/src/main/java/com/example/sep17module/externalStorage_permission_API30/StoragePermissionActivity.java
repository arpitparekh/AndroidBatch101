package com.example.sep17module.externalStorage_permission_API30;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityStoragePermissionBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StoragePermissionActivity extends AppCompatActivity {

    private ActivityStoragePermissionBinding binding;
    private ActivityResultLauncher<Intent> permission;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStoragePermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        permission = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onActivityResult(ActivityResult result) {
                if(Environment.isExternalStorageManager()) {
                    Toast.makeText(StoragePermissionActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(StoragePermissionActivity.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();

                }
            }
        });

        checkStoragePermission();

        binding.btnWrite.setOnClickListener(view -> {

            String data = binding.edtPermission.getText().toString();

            File file = Environment.getExternalStorageDirectory();

            file = new File(file,"Hello");

            if(file.mkdir()){

                Toast.makeText(StoragePermissionActivity.this, "File Created Successfully", Toast.LENGTH_SHORT).show();
            }else{

            }
            file = new File(file,"hello.txt");

            FileOutputStream os = null;
            try {
                os = new FileOutputStream(file);
                os.write(data.getBytes());
                os.close();

                Toast.makeText(StoragePermissionActivity.this, "Data Write Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void checkStoragePermission() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){

            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){

                if(!Environment.isExternalStorageManager()){
                    try{
                        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                        permission.launch(intent);
                    }catch (Exception e){
                        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                        permission.launch(intent);
                    }
                }

            }else {

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults.length>0){
                Toast.makeText(StoragePermissionActivity.this,"Done",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(StoragePermissionActivity.this,"Nope",Toast.LENGTH_SHORT).show();
            }
        }
    }
}