package com.example.sep17module.mvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sep17module.R;
import com.example.sep17module.databinding.FragmentF2Binding;


public class F2Fragment extends Fragment {

    private FragmentF2Binding binding;
    SharedViewModel model;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentF2Binding.inflate(inflater,container,false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        model.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

                binding.edtMvvm2.setText(s);
            }
        });


        binding.btnSubmitMvvm2.setOnClickListener(view1 -> {


            String name = binding.edtMvvm2.getText().toString();

            model.setData(name);

        });
    }
}