package com.example.retrofit_iii;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Headers("Authorization: Client-ID edeae775c755190")
    @POST("3/image")
    @Multipart
    Call<Response> uploadImage(
            @Part MultipartBody.Part file,
            @Part("title") String title
    );
}
