package com.example.sep17module.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.sep17module.databinding.ActivityMyRetroBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRetroActivity extends AppCompatActivity {
    private ActivityMyRetroBinding binding;
    List<MyPhoto>  myList;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRetroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myList = new ArrayList<>();

        pd = new ProgressDialog(this);
        pd.setTitle("Downloading Data...");
        pd.setMessage("Downloading...");
        pd.show();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyPhotoAdapter adapter = new MyPhotoAdapter();


        RetrofitService service = RetrofitClient.getRetroService();

        Call<List<MyPhoto>> call = service.getAllPhotoData();

        call.enqueue(new Callback<List<MyPhoto>>() {
            @Override
            public void onResponse(Call<List<MyPhoto>> call, Response<List<MyPhoto>> response) {

                myList = response.body();
                adapter.setList(myList);

                binding.recyclerView.setAdapter(adapter);
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<List<MyPhoto>> call, Throwable t) {
                Log.i("callError",t.toString());
            }
        });
    }
}