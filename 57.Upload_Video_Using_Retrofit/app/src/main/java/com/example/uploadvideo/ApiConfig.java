package com.example.uploadvideo;

import com.example.uploadvideo.Model.ResponseModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface ApiConfig {


    @POST("3/upload")
    Call<ResponseModel> upload(
            @Header("Authorization: Client-ID edeae775c755190") String authorization,
            @PartMap Map<String, RequestBody> map
    );
}
