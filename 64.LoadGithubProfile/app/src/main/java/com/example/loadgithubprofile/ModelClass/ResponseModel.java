package com.example.loadgithubprofile.ModelClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseModel{

    @SerializedName("ResponseModel")
    private List<ResponseModelItem> responseModel;

    public List<ResponseModelItem> getResponseModel(){
        return responseModel;
    }
}