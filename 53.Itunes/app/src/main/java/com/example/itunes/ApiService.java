package com.example.itunes;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search")
    Call<ResponseModel> getSearch(@Query("term") String searchTerm);

}
