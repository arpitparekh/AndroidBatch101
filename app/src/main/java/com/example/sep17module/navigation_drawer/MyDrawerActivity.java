package com.example.sep17module.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMyDrawerBinding;
import com.example.sep17module.databinding.NavigationHeaderLayoutBinding;
import com.google.android.material.navigation.NavigationView;

public class MyDrawerActivity extends AppCompatActivity {
    private ActivityMyDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDrawerBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.menu1){

                    Toast.makeText(MyDrawerActivity.this,"this is menu 1",Toast.LENGTH_LONG).show();
                }
                if(item.getItemId()==R.id.menu2){

                    Toast.makeText(MyDrawerActivity.this,"this is menu 2",Toast.LENGTH_LONG).show();
                }
                if(item.getItemId()==R.id.menu3){

                    Toast.makeText(MyDrawerActivity.this,"this is menu 3",Toast.LENGTH_LONG).show();
                }
                if(item.getItemId()==R.id.menu4){

                    Toast.makeText(MyDrawerActivity.this,"this is menu 4",Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        View view =binding.navDrawer.getHeaderView(0);

        ImageView iv = view.findViewById(R.id.imageView3);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyDrawerActivity.this,"this is image ",Toast.LENGTH_LONG).show();
            }
        });





    }
}