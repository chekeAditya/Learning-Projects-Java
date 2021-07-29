package com.example.uploadvideo.Model;

import com.google.gson.annotations.SerializedName;

public class Processing {
    @SerializedName("status")
    private String status;

    public String getStatus(){
        return status;
    }
}
