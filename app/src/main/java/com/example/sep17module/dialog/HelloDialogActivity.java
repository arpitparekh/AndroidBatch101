package com.example.sep17module.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.sep17module.databinding.ActivityHelloDialogBinding;
import com.example.sep17module.databinding.CustomDialogBinding;

public class HelloDialogActivity extends AppCompatActivity {

    private ActivityHelloDialogBinding binding;
    private CustomDialogBinding binding1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelloDialogBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.buttonShowDialog.setOnClickListener(view -> {



            AlertDialog.Builder builder =new AlertDialog.Builder(this);

            builder.setTitle("Custom Dialog");

            binding1=CustomDialogBinding.inflate(getLayoutInflater());
            builder.setView(binding1.getRoot());

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String name = binding1.edtName.getText().toString();

                    binding.textViewDialog.setText(name);


                }
            });
            builder.show();

        });
    }
}