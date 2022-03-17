package com.example.sep17module.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("photos")
    Call<List<MyPhoto>> getAllPhotoData();
}
