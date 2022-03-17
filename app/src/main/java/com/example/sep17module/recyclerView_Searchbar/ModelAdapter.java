package com.example.sep17module.recyclerView_Searchbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep17module.databinding.ModelRowItemBinding;

import java.util.ArrayList;
import java.util.Collection;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> implements Filterable {

    ArrayList<Model> modelArrayList;

    ArrayList<Model> list;

    Operation o;

    Context context;

    int position1;

    public interface Operation{
        void updateList(ArrayList<Model> modelArrayList);
    }

    public void setO(Operation o) {
        this.o = o;
    }

    public void setModelArrayList(ArrayList<Model> modelArrayList) {
        this.modelArrayList = modelArrayList;

        list = new ArrayList<>(modelArrayList);  // copy original list into another one
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ModelRowItemBinding binding = ModelRowItemBinding.inflate(inflater,parent,false);
        context = parent.getContext();
        ModelViewHolder viewHolder = new ModelViewHolder(binding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {

        Model m = modelArrayList.get(position);

        holder.binding.setValue(m);

        holder.itemView.setOnClickListener(view -> {

            Toast.makeText(context, String.valueOf(position) , Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }



    public class ModelViewHolder extends RecyclerView.ViewHolder {
        ModelRowItemBinding binding;
        public ModelViewHolder(@NonNull ModelRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                ArrayList<Model> filteredList = new ArrayList<>();

                if(charSequence.toString().isEmpty()){

                    filteredList.addAll(list);
                }

                for(Model model : list){

                    if(model.getEmail().toLowerCase().contains(charSequence.toString().toLowerCase())){

                        filteredList.add(model);
                    }
                }

                FilterResults results = new FilterResults();

                results.values = filteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                ArrayList<Model> newList = (ArrayList<Model>) filterResults.values;

//                int positionNew = 0;
//
//                for(Model m : modelArrayList){
//
//                    for(Model m2 : newList){
//
//                        positionNew = newList.indexOf(m2);
//
//                        if(m.equals(m2)){
//
//                           int position = modelArrayList.indexOf(m) ;
//
//
//
//                           positionNew = position;
//
//                           newList.set(positionNew,m2);
//
//
//                        }
//                    }
//                }

                modelArrayList = newList;

//                ArrayList<?> list = new ArrayList<>();

                o.updateList(modelArrayList);
                notifyDataSetChanged();
            }
        };
    }
}
