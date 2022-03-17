package com.example.sep17module.bottom_sheet_another;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sep17module.databinding.DemoLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class PuneFragment extends BottomSheetDialogFragment {
    String name;
    PuneFragment(String data){
        name=data;
    }

    private DemoLayoutBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=DemoLayoutBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.tvSheet.setText();

        binding.tvSheet.setText(name);

    }
}
