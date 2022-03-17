package com.example.sep17module.json_data.server;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityGetJsonBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetJsonActivity extends AppCompatActivity {

    private ActivityGetJsonBinding binding;
    private String data;
    ArrayList<MyData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGetJsonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        fetchDataFromServer();

    }

    private void fetchDataFromServer() {

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();
                try {

                    Response response = client.newCall(request).execute();
                    data = response.body().string();

                } catch (IOException e) {
                    Log.i("error",e.getMessage());
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Log.i("data",data);

                        try {

                            JSONArray array = new JSONArray(data);

                            for(int i=0;i< array.length();i++){

                                JSONObject object = array.getJSONObject(i);

                                String title = object.getString("title");
                                String body = object.getString("body");

                                MyData data = new MyData(title,body);

                                list.add(data);

                                Log.i("title",title);
                                Log.i("body",body);
                            }
                            ArrayAdapter<MyData> adapter = new ArrayAdapter<>(GetJsonActivity.this, android.R.layout.simple_list_item_1,list);
                            binding.listViewJson.setAdapter(adapter);

                        } catch (JSONException e) {
                            Log.i("error",e.getMessage());
                        }

                    }
                });

            }



        });



    }
}