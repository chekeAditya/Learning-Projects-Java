package com.example.postrequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<RequestModel> getRequest();

}
