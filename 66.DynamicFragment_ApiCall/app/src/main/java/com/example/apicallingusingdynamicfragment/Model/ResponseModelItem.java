package com.example.apicallingusingdynamicfragment.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseModelItem{

    @SerializedName("image")
    private String image;

    @SerializedName("subTitle")
    private String subTitle;

    @SerializedName("title")
    private String title;

    public String getImage(){
        return image;
    }

    public String getSubTitle(){
        return subTitle;
    }

    public String getTitle(){
        return title;
    }
}