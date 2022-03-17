package com.example.sep17module.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.example.sep17module.databinding.ActivityCustomDialogBinding;
import com.example.sep17module.databinding.CustomDialogBinding;

public class CustomDialog extends AppCompatActivity {
    private ActivityCustomDialogBinding binding;
    private CustomDialogBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityCustomDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonDialog.setOnClickListener(view -> {
            
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Custom Dialog");

            builder.setMessage("This is Custom Dialog");

            binding1=CustomDialogBinding.inflate(getLayoutInflater());

            builder.setView(binding1.getRoot());

            Log.i("log","create");



            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String name= binding1.edtName.getText().toString();
                    Log.i("name",name);
                    binding.tvText.setText(name);
                    dialogInterface.dismiss();
                }
            });

            builder.setNeutralButton("Cancel", (dialogInterface, i) -> {
                binding1.getRoot().removeAllViews();
                dialogInterface.dismiss();
            });
            builder.setOnDismissListener(dialogInterface -> dialogInterface.dismiss());

             builder.show();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("log","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("log","resume");
    }
}