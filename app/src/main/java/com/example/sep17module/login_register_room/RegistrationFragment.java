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
import com.example.sep17module.databinding.FragmentRegistrationBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;
    LoginDao dao;
    LoginDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentRegistrationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                database = LoginDatabase.getDatabase(getContext());

                dao = database.getDao();
            }
        });



        binding.btnRegister.setOnClickListener(view1 -> {

            List<LoginData> list = new ArrayList<>();

            list.add(new LoginData("ankit@gmail","12"));
            list.add(new LoginData("moin@gmail","12"));
            list.add(new LoginData("aman@gmail","12"));
            list.add(new LoginData("riya@gmail","12"));

            String email = binding.edtEmailRoomReg.getText().toString();
            String password = binding.edtPasswordReg.getText().toString();

            LoginData data = new LoginData(email,password);

            executor.execute(new Runnable() {
                @Override
                public void run() {

//                    dao.insert(data);
                    dao.insertWholeList(list);
                    long total = dao.total();
//                    dao.deleteTable();
                    requireActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(),String.valueOf(total), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });

            requireActivity().getSupportFragmentManager()
                    .beginTransaction().replace(R.id.fragmentContainer,new LoginFragment())
                    .commit();

        });

    }
}