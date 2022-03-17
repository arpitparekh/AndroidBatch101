package com.example.sep17module.crud_operation_firebase;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sep17module.R;
import com.example.sep17module.databinding.FragmentShowFirebaseDataBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class ShowFirebaseDataFragment extends Fragment {

    private FragmentShowFirebaseDataBinding binding;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ArrayList<HashMap<String,Student>> list;
    ArrayAdapter<HashMap<String,Student>> adapter;
    private Student student;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        binding=FragmentShowFirebaseDataBinding.inflate(getLayoutInflater());
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        database = FirebaseDatabase.getInstance();

        ref = database.getReference("student");

        list=new ArrayList<>();

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);

        binding.listviewFirebase.setAdapter(adapter);

        loadData();

        binding.listviewFirebase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HashMap<String,Student> map = list.get(i);

                String key1=null;

                for(String key:map.keySet()){
                    key1 = key;
                }


                Bundle b = new Bundle();
                b.putSerializable("object",map);


                String finalKey = key1;

                new AlertDialog.Builder(getContext())
                            .setPositiveButton("update", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    /////////////////////////////  update  ///////////////////
                                    requireActivity().getSupportFragmentManager()
                                            .beginTransaction()
                                            .replace(R.id.firebaseHost,AddFirebaseDataFragment.class,b)
                                            .addToBackStack("login")
                                            .commit();
                                }
                            }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ////////////////////////////////////  delete  ////////////////
                            ref.child(finalKey).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                            });


                        }
                    }).create().show();

            }
        });

    }
    ///////////////////////////////////////////   get data from firebase  /////////////////////
    private void loadData() {

        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();   // clear list for new data chnage

                for(DataSnapshot childSnap : snapshot.getChildren()){

                    Student s = childSnap.getValue(Student.class);
                    String key = childSnap.getKey();

                    HashMap<String,Student> map = new HashMap<>();
                    map.put(key,s);

                    list.add(map);

                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.add_data,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_add){

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.firebaseHost,new AddFirebaseDataFragment())
                    .addToBackStack("showData")
                    .commit();

        }
        return super.onOptionsItemSelected(item);
    }
}