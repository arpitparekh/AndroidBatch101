package com.example.sep17module.get_image_from_internal_to_imagevview;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.sep17module.databinding.ActivityGetImageBinding;

public class GetImageActivity extends AppCompatActivity {

    ActivityGetImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGetImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<String> getImage = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.ivFromInternal.setImageURI(result);
            }
        });

        binding.btnFromInternal.setOnClickListener(view -> {

            getImage.launch("*/*");

        });

    }
}