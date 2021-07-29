package com.example.getresourcesapi.Interface;

import com.example.getresourcesapi.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/unknown/{userId}")
    Call<ResponseModel> getUserId(@Path("userId") int userId);
}
