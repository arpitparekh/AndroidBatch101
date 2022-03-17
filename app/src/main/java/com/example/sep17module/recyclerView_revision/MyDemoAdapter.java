package com.example.sep17module.recyclerView_revision;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep17module.databinding.MyRowItemBinding;

import java.util.ArrayList;

public class MyDemoAdapter extends RecyclerView.Adapter<MyDemoAdapter.MyDemoViewHolder> {

    ArrayList<MyData>list;

    Context context;

    public void setList(ArrayList<MyData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyDemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context= parent.getContext();
        MyRowItemBinding binding=MyRowItemBinding.inflate(inflater,parent,false);
        MyDemoViewHolder viewHolder = new MyDemoViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyDemoViewHolder holder, int position) {
        MyData data= list.get(position);
        holder.binding.setValue(data);

        holder.itemView.setOnClickListener(view -> {

            Toast.makeText(context, data.name, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyDemoViewHolder extends RecyclerView.ViewHolder {
        private MyRowItemBinding binding;
        public MyDemoViewHolder(@NonNull MyRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
