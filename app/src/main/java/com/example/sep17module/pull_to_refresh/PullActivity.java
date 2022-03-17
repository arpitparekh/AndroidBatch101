package com.example.sep17module.pull_to_refresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityPullBinding;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;

public class PullActivity extends AppCompatActivity {
    private ActivityPullBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPullBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list = new ArrayList<>();

        list.add("Smit");
        list.add("Hemang");
        list.add("Ankit");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(adapter);

        binding.pullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.add("tops");
                adapter.notifyDataSetChanged();
                binding.pullToRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.pullToRefresh.setRefreshing(false);
                    }
                },1000);

            }
        });


    }
}