package com.example.sep17module.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMenuDemoBinding;

public class MenuDemoActivity extends AppCompatActivity {

    private ActivityMenuDemoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMenuDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.btnMenu);

        if(binding.btnMenu.isExtended()){
            binding.btnMenu.shrink();
        }

        binding.btnMenu.setOnClickListener(view -> {

            if(!binding.btnMenu.isExtended()){
                binding.btnMenu.extend();

                PopupMenu popupMenu=new PopupMenu(this,view);

                popupMenu.getMenuInflater().inflate(R.menu.option_menu_demo,popupMenu.getMenu());

                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        binding.btnMenu.shrink();
                    }
                });

                popupMenu.setOnMenuItemClickListener(menuItem -> {

                    switch (menuItem.getItemId()){

                        case R.id.action_Setting:
                            Toast.makeText(MenuDemoActivity.this, "Setting menu Popup", Toast.LENGTH_SHORT).show();

                            binding.btnMenu.shrink();
                            break;
                        case R.id.action_Profile:
                            Toast.makeText(MenuDemoActivity.this, "Setting Profile Popup", Toast.LENGTH_SHORT).show();
                            binding.btnMenu.shrink();
                            break;
                        case R.id.action_Logout:
                            Toast.makeText(MenuDemoActivity.this, "Setting Logout Popup", Toast.LENGTH_SHORT).show();
                            binding.btnMenu.shrink();
                            break;
                        case R.id.action_Search:
                            Toast.makeText(MenuDemoActivity.this, "Setting Search Popup", Toast.LENGTH_SHORT).show();
                            binding.btnMenu.shrink();
                            break;
                    }
                    return true;
                });

                popupMenu.show();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_demo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==R.id.action_Setting){
//
//            Toast.makeText(this, "Setting Menu", Toast.LENGTH_SHORT).show();
//
//        }

        switch (item.getItemId()){

            case R.id.action_Setting:
                Toast.makeText(this, "Setting menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Profile:
                Toast.makeText(this, "Setting Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Logout:
                Toast.makeText(this, "Setting Logout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Search:
                Toast.makeText(this, "Setting Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.option_menu_demo,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_Setting:
                Toast.makeText(this, "Setting menu on Long Press", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Profile:
                Toast.makeText(this, "Setting Profile on Long Press", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Logout:
                Toast.makeText(this, "Setting Logout on Long Press", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Search:
                Toast.makeText(this, "Setting Search on Long Press", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);


    }
}