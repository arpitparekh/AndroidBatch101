package com.example.sep17module.covid_19_data;

import com.example.sep17module.covid_19_data.pojo_class.CovidData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Covid19API {

    @GET("v1/stats")
    @Headers({"x-rapidapi-host: covid-19-coronavirus-statistics.p.rapidapi.com",
                "x-rapidapi-key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077"})
    Call<CovidData> getCovidData(@Query("country") String countryName);

}
