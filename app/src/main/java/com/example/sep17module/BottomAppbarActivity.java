package com.example.sep17module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityBottomAppbarBinding;

public class BottomAppbarActivity extends AppCompatActivity {
    private ActivityBottomAppbarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBottomAppbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BottomAppbarActivity.this, "Navigation Icon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.action1){
                    Toast.makeText(BottomAppbarActivity.this, "Action 1", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action2){
                    Toast.makeText(BottomAppbarActivity.this, "Action 2", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action3){
                    Toast.makeText(BottomAppbarActivity.this, "Action 3", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action4){
                    Toast.makeText(BottomAppbarActivity.this, "Action 4", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });


    }
}