package com.example.sep17module.bottom_sheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sep17module.databinding.BottomSheetDemoBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActionBottomSheetFragment extends BottomSheetDialogFragment {
    private BottomSheetDemoBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=BottomSheetDemoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button5.setOnClickListener(v->{
            showToast("button 5");
        });
        binding.button6.setOnClickListener(v->{
            showToast("button 6");
        });
        binding.button7.setOnClickListener(v->{
            showToast("Button 7");
        });
    }

    private void showToast(String name) {
        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
    }

}
