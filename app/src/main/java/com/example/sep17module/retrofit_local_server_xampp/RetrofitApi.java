package com.example.sep17module.retrofit_local_server_xampp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitApi {

    @GET("myfile.php?flag=SELECT")
    Call<List<Student>> getAllStudent();

    @FormUrlEncoded
    @POST("myfile.php?flag=INSERT")
    Call<String> sendDataToServer(@Field("id") int id,
                                  @Field("first_name") String first_name,
                                  @Field("email") String email,
                                  @Field("mobile_no") int mobile_no);
    @FormUrlEncoded
    @POST("myfile.php?flag=UPDATE")
    Call<String> updateDataOnServer(@Field("id") int id,
                                  @Field("first_name") String first_name,
                                  @Field("email") String email,
                                  @Field("mobile_no") int mobile_no);
    @FormUrlEncoded
    @POST("myfile.php?flag=DELETE")
    Call<String> deleteDataFromServer(@Field("id") int id);


}
