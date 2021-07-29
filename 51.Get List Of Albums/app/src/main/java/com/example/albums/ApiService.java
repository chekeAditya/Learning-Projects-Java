package com.example.albums;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("albums")
    Call<List<ResponseModel>> getAlbums();
}
