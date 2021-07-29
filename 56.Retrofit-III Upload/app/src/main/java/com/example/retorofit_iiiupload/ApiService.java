package com.example.retorofit_iiiupload;

import com.example.retorofit_iiiupload.Model.Response;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Headers("Authorization: Client-ID edeae775c755190")
    @POST("3/upload")
    @Multipart
    Call<Response> uploadVideo(
            @Part MultipartBody.Part file,
            @Part("upload") String title
    );
}
