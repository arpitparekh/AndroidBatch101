package com.example.sep17module.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMultiValueSelectCheckBoxBinding;

import java.util.ArrayList;

public class MultiValueSelectCheckBoxActivity extends AppCompatActivity {
    private ActivityMultiValueSelectCheckBoxBinding binding;
    private  String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMultiValueSelectCheckBoxBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String arr[]={"Hello","Hi","How a u?","Kem cho?"};



        binding.imageViewDialog.setOnClickListener(view -> {



            AlertDialog.Builder builder =new AlertDialog.Builder(this);

            builder.setTitle("Custom Dialog");

//            builder.setMessage("This is Custom Dialog");

            builder.setCancelable(false);
//            builder.setIcon(R.drawable.ic_yoga);

//            builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//
//                    if(b){
//
//                        list.add(arr[i]);
//                    }
//                    else if(list.contains(arr[i])){
//
//                        list.remove(arr[i]);
//                    }
//
//                }
//            });   3


            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    name = arr[i];

                }
            });

            builder.setPositiveButton("Show Dialog", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MultiValueSelectCheckBoxActivity.this, name, Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();


        });

    }
}