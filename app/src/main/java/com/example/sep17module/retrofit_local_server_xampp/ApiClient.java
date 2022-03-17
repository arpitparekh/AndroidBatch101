package com.example.sep17module.retrofit_local_server_xampp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {

    public static RetrofitApi getApi(){

        // replace

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("http://192.168.1.58/practice/") // replace with your pc IP address
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitApi api = retrofit.create(RetrofitApi.class);

        return api;
    }

}
