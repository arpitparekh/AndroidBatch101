package com.example.sep17module.login_register_room;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.FragmentLoginBinding;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    LoginDatabase database;
    LoginDao dao;
    boolean b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Executor executor = Executors.newSingleThreadExecutor();

        database = LoginDatabase.getDatabase(getContext());

        dao = database.getDao();

        binding.tvRegister.setOnClickListener(view1 -> {

            requireActivity().getSupportFragmentManager()
                    .beginTransaction().replace(R.id.fragmentContainer,new RegistrationFragment())
                    .addToBackStack("login")
                    .commit();
        });

        binding.btnLogin.setOnClickListener(view1 -> {
//            String emailLogin = loginData.email.toString();
//            String passwordLogin = loginData.password.toString();

            String email = binding.edtEmailRoom.getText().toString();
            String password = binding.edtPassword.getText().toString();

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    b = dao.checkLogin(email,password);

                    requireActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (b){

                                Toast.makeText(getContext(), "Login SuccessFul", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getContext(), "Login UnSuccessFul", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });








        });
    }
}