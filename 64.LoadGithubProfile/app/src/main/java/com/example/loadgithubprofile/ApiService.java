package com.example.loadgithubprofile;

import com.example.loadgithubprofile.ModelClass.ResponseModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/users/{user}/repos")
    Call<List<ResponseModelItem>> getData(@Path("user") String user);
}
