package com.example.apicallingusingservice.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("userId")
    private Integer userId;

    public ResponseModel(Integer id, String title, String body, Integer userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public Integer getUserId(){
        return userId;
    }
}