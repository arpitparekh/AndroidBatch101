package com.example.sep17module.externalStorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityMyExternalStorageBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyExternalStorageActivity extends AppCompatActivity {

    private ActivityMyExternalStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getPermission();

        ////////////////////////////////////////////////////////// store  ////////////////////////////////
        binding.btnStoreExt.setOnClickListener(view -> {

            String name = binding.edtExtString.getText().toString();

            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            file = new File(file,"MyFolder");

            if(!file.exists()){

                if(file.mkdir()){

                    Toast.makeText(this, "File Created", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(MyExternalStorageActivity.this,"File Cannot be Created",Toast.LENGTH_LONG).show();

                }

            }

            file = new File(file,"myTxt.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);

                fos.write(name.getBytes());

                fos.flush();
                fos.close();

                Toast.makeText(MyExternalStorageActivity.this,"File Write Successfully",Toast.LENGTH_LONG).show();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });
        //////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////  read /////////////////////////////////////////////
        binding.btnReadExt.setOnClickListener(view -> {

            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            file = new File(file,"MyFolder");

            if(!file.exists()){

                if(file.mkdir()){

                    Toast.makeText(this, "File Created", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(MyExternalStorageActivity.this,"File Cannot be Created",Toast.LENGTH_LONG).show();

                }

            }

            file = new File(file,"myTxt.txt");

            try {

                FileInputStream fis = new FileInputStream(file);
                byte arr[] = new byte[fis.available()];
                fis.read(arr);
                String name = new String(arr);

                binding.tvReadString.setText(name);



            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        //////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private void getPermission() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(MyExternalStorageActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MyExternalStorageActivity.this,"Permission de",Toast.LENGTH_LONG).show();
            }
        }
    }
}