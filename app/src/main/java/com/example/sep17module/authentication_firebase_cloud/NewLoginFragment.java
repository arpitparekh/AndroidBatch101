package com.example.sep17module.authentication_firebase_cloud;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.FragmentNewLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class NewLoginFragment extends Fragment {

   private FragmentNewLoginBinding binding;
   private Context context;
   private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentNewLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();
        context = getContext();

        binding.tvNewUser.setOnClickListener(view1 -> {

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fcv_firebase,new NewRegistrationFragment())
                    .addToBackStack("login")
                    .commit();

        });

        binding.btnLoginFire.setOnClickListener(view1 -> {

            String email = binding.edtEmailFire.getText().toString();
            String password = binding.edtPasswordFire.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()){

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        binding.edtPasswordFire.setError(e.toString());
                    }
                });

            }else{
                Toast.makeText(context, "Empty Field", Toast.LENGTH_SHORT).show();
            }

        });

        binding.tvForget.setOnClickListener(view1 -> {

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fcv_firebase,new NewForgetFragment())
                    .addToBackStack("forgot")
                    .commit();

        });


    }
}