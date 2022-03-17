package com.example.sep17module.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.example.sep17module.databinding.ActivityMyDialogBinding;

public class MyDialogActivity extends AppCompatActivity {

    private ActivityMyDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonDialog.setOnClickListener(view -> {


            AlertDialog.Builder builder =new AlertDialog.Builder(this);

            builder.setTitle("Choose One");
            builder.setMessage("Please Choose One");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    binding.parentChangeBackground.setBackgroundColor(Color.rgb(255,128,0));
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.show();

        });
    }
}