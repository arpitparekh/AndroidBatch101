package com.example.sep17module.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityAutoCompleteBinding;

import java.util.ArrayList;

public class AutoCompleteActivity extends AppCompatActivity {
    private ActivityAutoCompleteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAutoCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("How are U?");
        list.add("Kem cho?");
        list.add("Welcome");
        list.add("Hurray");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.tvAutoComplete.setAdapter(adapter);
        binding.tvAutoComplete.setThreshold(1);
    }
}