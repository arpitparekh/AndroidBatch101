package com.example.sep17module.bottom_sheet_another;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityGoaBinding;

import java.util.ArrayList;

public class GoaActivity extends AppCompatActivity {

    private ActivityGoaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGoaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list =new ArrayList<>();

        list.add("Hemang");
        list.add("Smit");
        list.add("Mahesh");
        list.add("Ankit");
        list.add("Apple");
        list.add("Android");
        list.add("Andromada");
        list.add("Apple Juice");

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,list);

        binding.listView.setAdapter(adapter);


        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data =list.get(position);


                PuneFragment p =new PuneFragment(data);
                p.show(getSupportFragmentManager(),"mySheet");
            }
        });

//        binding.btnAddItems.setOnClickListener(v -> {
//
//            list.add("Data");
//
//            adapter.notifyDataSetChanged();
//        });


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }
}