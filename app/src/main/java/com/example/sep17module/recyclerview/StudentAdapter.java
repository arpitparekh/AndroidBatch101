package com.example.sep17module.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep17module.databinding.DetailRowItemBinding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private ArrayList<Fun> list;   //fun ka data

    private onItemClickListener listener;

    Context context;

    StudentAdapter(ArrayList<Fun> list,onItemClickListener listener){

        this.list=list;  // list from activity
        this.listener=listener;
    }

    // click event  /////////////////////////////////////////////////////////////////

    public interface onItemClickListener{   // interface

        void onClick(int position);   // abstract method // single click
        void onLongClick(int position);  // long click
    }


    //////////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // individual itemView
        context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DetailRowItemBinding binding = DetailRowItemBinding.inflate(inflater,parent,false);
        StudentViewHolder viewHolder =new StudentViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Fun fun = list.get(position);


        holder.binding.setData(fun);     // dataBinding

        if(position%2==0){
            holder.binding.linear.setBackgroundColor(Color.LTGRAY);   // change color
        }

        holder.itemView.setOnClickListener(view -> {

            listener.onClick(position);
        });

        holder.itemView.setOnLongClickListener(view -> {

            listener.onLongClick(position);

            // This returns a boolean to indicate whether you have consumed the event and it should not be carried further. That is, return true to indicate that you have handled the event and it should stop here; return false if you have not handled it and/or the event should continue to any other on-click listeners.

            return false;
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        // item inside itemView

        private DetailRowItemBinding binding;
        public StudentViewHolder(@NonNull DetailRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
