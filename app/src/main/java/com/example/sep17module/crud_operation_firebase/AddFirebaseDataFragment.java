package com.example.sep17module.crud_operation_firebase;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.FragmentAddFirebaseDataBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AddFirebaseDataFragment extends Fragment {

   private FragmentAddFirebaseDataBinding binding;
   private FirebaseDatabase database;
   private DatabaseReference ref;
   private Map<String,Student> map;
   String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAddFirebaseDataBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Bundle b = getArguments();

        if(b!=null){                  // update  /////////////////////////////

             map = (Map<String, Student>) b.getSerializable("object");

             for(Student s : map.values()){
                 binding.edtFirebaseEmail.setText(s.email);
                 binding.edtFirebaseName.setText(s.name);
                 binding.edtFirebaseId.setText(String.valueOf(s.id));
             }
        }

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("student");

        binding.btnSendFirebase.setOnClickListener(view1 -> {

            if(map==null){   // insert ///////////////////////////////////////////////////

                int id = Integer.parseInt(binding.edtFirebaseId.getText().toString());
                String name = binding.edtFirebaseName.getText().toString();
                String email = binding.edtFirebaseEmail.getText().toString();

                Student s1 = new Student(email,id,name);

                ref.push().setValue(s1).addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(getContext(), "Data Added", Toast.LENGTH_SHORT).show();

                            requireActivity().getSupportFragmentManager().popBackStack();  // go back to previous fragment
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("errorFire",e.toString());
                    }
                });

            }else{  // update  ///////////////////////////////////////////////////////////////////////

                for(String key : map.keySet()){
                    this.key = key;
                }

                int id = Integer.parseInt(binding.edtFirebaseId.getText().toString());
                String name = binding.edtFirebaseName.getText().toString();
                String email = binding.edtFirebaseEmail.getText().toString();

                Student s1 = new Student(email,id,name);

                map.replace(key,s1);

                Map<String, Object> newMap = new HashMap<>(map);
                ref.updateChildren(newMap);

                requireActivity().getSupportFragmentManager().popBackStack();

            }

        });

    }
}