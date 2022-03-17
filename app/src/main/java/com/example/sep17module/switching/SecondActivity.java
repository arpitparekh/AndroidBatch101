package com.example.sep17module.switching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sep17module.R;
import com.example.sep17module.classes.Student;
import com.example.sep17module.databinding.ActivitySecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



//        TextView tv=findViewById(R.id.tvObjectData);
//        Intent intent = getIntent();
//
//        Student s=intent.getParcelableExtra("object");
//        tv.setText(s.toString());

    }

//    @Override
//    public void onBackPressed() {
//
//        new AlertDialog.Builder(this)
//                .setTitle("Do u really Really want to close?")
//                .setIcon(R.drawable.ic_yoga)
//                .setPositiveButton("Ha bhai", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        SecondActivity.super.onBackPressed();
//                        Snackbar.make(binding.secondActivity,"Welcome to the First Activity",Snackbar.LENGTH_LONG).show();
//                    }
//                })
//                .setNegativeButton("Na bhai", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        Intent intent=new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        startActivity(intent);
//                    }
//                }).create().show();
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_out,R.anim.slide_out);
    }
}