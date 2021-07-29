package com.example.uploadvideo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface AppConfig {
    public static String BASE_URL = "https://api.imgur.com/";

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
