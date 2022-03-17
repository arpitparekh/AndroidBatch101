package com.example.sep17module.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityListViewBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ActivityListViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> myList = new ArrayList<>();

        myList.add("Smit");
        myList.add("Rahil");
        myList.add("Ankit");
        myList.add("kenil");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,myList);

        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i,long l) {

                    Snackbar.make(binding.myLinearList,adapterView.getItemAtPosition(i).toString(),Snackbar.LENGTH_LONG).show();

            }
        });

//        binding.listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i==0){
//
//                    Snackbar.make(binding.myLinearList,adapterView.getSelectedItem().toString(),Snackbar.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


    }
}