package com.example.sep17module.recyclerView_revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.sep17module.databinding.ActivityMyRecyclerViewBinding;

import java.util.ArrayList;

public class MyRecyclerView extends AppCompatActivity {
    private ActivityMyRecyclerViewBinding binding;
    private ArrayList<MyData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));

        list = new ArrayList<>();

        list.add(new MyData("smitth","smit@gmail.com","vadala"));
        list.add(new MyData("moin","moin@gmail.com","vadala"));
        list.add(new MyData("adnan","adnan@gmail.com","vadala"));
        list.add(new MyData("anand","anand@gmail.com","vadala"));
        list.add(new MyData("smitisha","smitisha@gmail.com","vadala"));

        MyDemoAdapter adapter = new MyDemoAdapter();

        adapter.setList(list);

        binding.recyclerView.setAdapter(adapter);
    }
}