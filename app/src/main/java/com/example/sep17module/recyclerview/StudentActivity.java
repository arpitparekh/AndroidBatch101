package com.example.sep17module.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityStudentBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity implements StudentAdapter.onItemClickListener {

    private ActivityStudentBinding binding;
    private ArrayList<Fun> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // linear
        // grid
        // staggered grid

//        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);


        // 3 edittext

        list = new ArrayList<>();
        list.add(new Fun("Arpit", "arrwer.com", "86754683463"));
        list.add(new Fun("Smit", "sadas.com", "675575765"));
        list.add(new Fun("Hasmit", "yuiyui.com", "547547"));
        list.add(new Fun("Prosmit", "nmbn.com", "75547"));
        list.add(new Fun("Drish", "ewwe.com", "547547"));


        StudentAdapter adapter = new StudentAdapter(list,this);

        binding.recyclerView.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.END,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.LEFT){
                    showConfirmDialog(position);
                }
                else{



                }
            }



            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                Paint paint = new Paint();
                View itemView = viewHolder.itemView;
                Bitmap bitmap;
                int height = itemView.getHeight();
                int width = height/3;
                if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE){

                    if(dX>0){

                        paint.setColor(Color.GREEN);

                        c.drawRect(itemView.getLeft(),itemView.getTop(),dX,itemView.getBottom(),paint);

                        bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_edit);

                        c.drawBitmap(bitmap,width,itemView.getTop()+width,paint);

                    } else {

                        paint.setColor(Color.RED);

                        c.drawRect(itemView.getRight()+dX,itemView.getTop(),itemView.getRight(),itemView.getBottom(),paint);

                        bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_delete);

                        c.drawBitmap(bitmap,itemView.getRight()-(width),itemView.getTop()+width,paint);
                    }

                }
            }
        });
        helper.attachToRecyclerView(binding.recyclerView);

    }

    private void showConfirmDialog(int position) {

    }

    @Override
    public void onClick(int position) {

        Fun fun = list.get(position);
        Toast.makeText(StudentActivity.this,fun.name + fun.email + fun.number,Toast.LENGTH_LONG).show();


    }

    @Override
    public void onLongClick(int position) {
        Fun fun = list.get(position);

        Snackbar.make(binding.linearParent,fun.name + fun.email + fun.number,Snackbar.LENGTH_SHORT).show();
    }
}
