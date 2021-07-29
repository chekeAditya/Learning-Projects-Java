package com.example.retorofit_iiiupload.Model;

import com.google.gson.annotations.SerializedName;

public class Response{

    @SerializedName("data")
    private Data data;

    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private Integer status;

    public Data getData(){
        return data;
    }

    public boolean isSuccess(){
        return success;
    }

    public Integer getStatus(){
        return status;
    }
}