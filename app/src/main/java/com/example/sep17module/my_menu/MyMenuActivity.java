package com.example.sep17module.my_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMyMenuBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public class MyMenuActivity extends AppCompatActivity {

    private ActivityMyMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        registerForContextMenu(binding.button);

        // menu  1 Option menu   2  Context Menu 3 Popup menu

        binding.button.setOnClickListener(view -> {

            PopupMenu popupMenu=new PopupMenu(this,view);

            popupMenu.getMenuInflater().inflate(R.menu.my_menu,popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if(menuItem.getItemId()==R.id.action_Add){
                        Toast.makeText(MyMenuActivity.this, "Addition", Toast.LENGTH_SHORT).show();
                    }
                    if(menuItem.getItemId()==R.id.action_Sub){
                        Toast.makeText(MyMenuActivity.this, "Subtraction", Toast.LENGTH_SHORT).show();
                    }
                    if(menuItem.getItemId()==R.id.action_Mul){
                        Toast.makeText(MyMenuActivity.this, "Multiplication", Toast.LENGTH_SHORT).show();
                    }
                    if(menuItem.getItemId()==R.id.action_Div){
                        Toast.makeText(MyMenuActivity.this, "Divition", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });

            popupMenu.show();

        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.action_Add){
//            Toast.makeText(this,"Addition From Context",Toast.LENGTH_SHORT).show();
            Snackbar.make(binding.myMenu,"This is SnackBar",Snackbar.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.action_Mul){
            Toast.makeText(this,"Multiplication From Context",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.action_Div){
            Toast.makeText(this,"Division From Context",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.action_Sub){
            Toast.makeText(this,"Subtraction From Context",Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_Add){
            Toast.makeText(this,"add Something",Toast.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.action_Sub){
            Snackbar.make(binding.myMenu,"Subtract Something",Snackbar.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.action_Mul){
            Snackbar.make(binding.myMenu,"Multiplication Something",Snackbar.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.action_Div){
            Snackbar.make(binding.myMenu,"Division Something",Snackbar.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}