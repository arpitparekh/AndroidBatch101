package com.example.sep17module.recyclerView_Searchbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMyRecyclerSearchBinding;
import com.example.sep17module.databinding.ActivityMyRecyclerViewBinding;

import java.util.ArrayList;

public class MyRecyclerSearchActivity extends AppCompatActivity implements ModelAdapter.Operation {
    private ActivityMyRecyclerSearchBinding binding;
    private ArrayList<Model> modelArrayList;
    private ModelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRecyclerSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.recyclerViewSearch.setLayoutManager(new LinearLayoutManager(this));

        modelArrayList = new ArrayList<>();
        adapter = new ModelAdapter();

        modelArrayList.add(new Model("smit",34,"smit@gmail.com"));
        modelArrayList.add(new Model("Adnan",34,"Adnan@gmail.com"));
        modelArrayList.add(new Model("Moin",24,"Moin@gmail.com"));
        modelArrayList.add(new Model("Aman",27,"Aman@gmail.com"));
        modelArrayList.add(new Model("Hemang",12,"Hemang@gmail.com"));
        modelArrayList.add(new Model("Rahul",13,"Rahul@gmail.com"));
        modelArrayList.add(new Model("Hetvi",14,"Hetvi@gmail.com"));

        adapter.setModelArrayList(modelArrayList);

        adapter.setO(this);

        binding.recyclerViewSearch.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void updateList(ArrayList<Model> modelArrayListNew) {

    }
}