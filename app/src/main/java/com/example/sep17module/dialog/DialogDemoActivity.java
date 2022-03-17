package com.example.sep17module.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityAnotherHolderBinding;
import com.example.sep17module.databinding.ActivityDialogDemoBinding;

public class DialogDemoActivity extends AppCompatActivity {

    private ActivityDialogDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDialogDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOpenDialog.setOnClickListener(view -> {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);

            builder.setTitle("This is Titlte");
            builder.setMessage("dgsg");
//            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialogInterface) {
//                    builder.create().show();
//                }
//            }).create().show();

           new AlertDialog.Builder(this)
                   .setOnDismissListener(new DialogInterface.OnDismissListener() {
                       @Override
                       public void onDismiss(DialogInterface dialogInterface) {

                       }
                   })
                   .setTitle("Choose One")
                   .setMessage("Hello Student")

                   .setIcon(R.drawable.ic_verified)
                   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(DialogDemoActivity.this, "Click on Yes", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(DialogDemoActivity.this, "Click on No", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(DialogDemoActivity.this, "Click on Cancel", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .create().show();



        });


    }
}