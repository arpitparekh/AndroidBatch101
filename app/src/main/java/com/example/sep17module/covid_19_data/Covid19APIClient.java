package com.example.sep17module.covid_19_data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Covid19APIClient {

    public static Covid19API getAPI(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-19-coronavirus-statistics.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Covid19API api = retrofit.create(Covid19API.class);

        return api;

    }

}
