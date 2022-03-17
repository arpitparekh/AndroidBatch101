package com.example.sep17module.retrofit_local_server_xampp;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.AddStudentDataDialogBinding;
import com.example.sep17module.databinding.FragmentStudentListBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentListFragment extends Fragment {


    private FragmentStudentListBinding binding;
    private AddStudentDataDialogBinding binding1;
    ArrayAdapter<Student> adapter;
    List<Student> list;
    RetrofitApi api;
    Call<List<Student>> call;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding=FragmentStudentListBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);   // option menu in android
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refreshAdapter();

        binding.listviewDataFromServer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding1 = AddStudentDataDialogBinding.inflate(getLayoutInflater());
                Student s = list.get(i);

                String id = s.getId();
                String first_name = s.getFirstName();
                String email = s.getEmail();
                String mobile = s.getMobileNo();

                binding1.edtIdServer.setText(id);
                binding1.edtNameServer.setText(first_name);
                binding1.edtEmailServer.setText(email);
                binding1.edtMobileServer.setText(mobile);

                binding1.edtIdServer.setEnabled(false);

                new AlertDialog.Builder(getContext())
                        .setView(binding1.getRoot())
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                int id = Integer.parseInt(binding1.edtIdServer.getText().toString());
                                String first_name = binding1.edtNameServer.getText().toString();
                                String email = binding1.edtEmailServer.getText().toString();
                                int mobile = Integer.parseInt(binding1.edtMobileServer.getText().toString());

                                Call<String> call = api.updateDataOnServer(id, first_name, email, mobile);

                                call.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Log.i("errorServer", t.toString());
                                    }
                                });

                                    refreshAdapter();
                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int id = Integer.parseInt(s.getId());

                                Call<String> call = api.deleteDataFromServer(id);

                                call.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Log.i("errorServer", t.toString());
                                    }
                                });

                                refreshAdapter();

                            }
                        })
                        .create().show();
            }
        });
    }

    private void refreshAdapter() {
        api = ApiClient.getApi();

        call =  api.getAllStudent();

        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                list = response.body();

                adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);

                binding.listviewDataFromServer.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.i("serverError",t.toString());
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

        binding1 = AddStudentDataDialogBinding.inflate(getLayoutInflater());

        if(item.getItemId()==R.id.action_add){

            new AlertDialog.Builder(getContext())
                    .setView(binding1.getRoot())
                    .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            int id = Integer.parseInt(binding1.edtIdServer.getText().toString());
                            String name = binding1.edtNameServer.getText().toString();
                            String email = binding1.edtEmailServer.getText().toString();
                            int mobile_no = Integer.parseInt(binding1.edtMobileServer.getText().toString());

                            Call<String> call = api.sendDataToServer(id,name,email,mobile_no);

                            call.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {

                                    Toast.makeText(getContext(), "Data Send Successfully", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Log.i("serverError1",t.toString());
                                }
                            });

                            refreshAdapter();

                        }
                    }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }
}