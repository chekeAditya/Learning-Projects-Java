package com.example.retrofit_i;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    //id of userId in line number 10 should be same as that of 11th

    @GET("api/users/{userid}")
    Call<ResponseDTO> getUser(@Path("userid") int userid);

}
