package com.example.sep17module.spinnerPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityMySpinnerBinding;

import java.util.ArrayList;

public class MySpinnerActivity extends AppCompatActivity {
    private ActivityMySpinnerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("hi");
        list.add("How r u?");
        list.add("Kem cho?");
        list.add("Kese Ho ?");
        list.add("hola");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.mySpinner.setAdapter(adapter);

//        binding.mySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Toast.makeText(MySpinnerActivity.this,list.get(i),Toast.LENGTH_SHORT).show();
//            }
//        });

        binding.mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MySpinnerActivity.this,list.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}