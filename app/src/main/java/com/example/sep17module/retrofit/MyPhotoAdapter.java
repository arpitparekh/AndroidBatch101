package com.example.sep17module.retrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sep17module.databinding.RetroRawItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyPhotoAdapter extends RecyclerView.Adapter<MyPhotoAdapter.MyPhotoViewHolder> {

    List<MyPhoto> list;
    Context context;

    public void setList(List<MyPhoto> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyPhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RetroRawItemBinding binding= RetroRawItemBinding.inflate(inflater,parent,false);
        MyPhotoViewHolder viewHolder = new MyPhotoViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyPhotoViewHolder holder, int position) {
        MyPhoto photo = list.get(position);
        holder.binding.setData(photo);

        Picasso.get()
                .load(photo.getUrl())
                .resize(50, 50)
                .centerCrop()
                .into(holder.binding.imageView5);
        Picasso.get()
                .load(photo.getThumbnailUrl())
                .resize(50, 50)
                .centerCrop()
                .into(holder.binding.imageView4);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyPhotoViewHolder extends RecyclerView.ViewHolder {
        RetroRawItemBinding binding;
        public MyPhotoViewHolder(@NonNull RetroRawItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
