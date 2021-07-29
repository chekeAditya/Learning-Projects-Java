package com.example.retrofit_i;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("data")
	private DataDTO data;

	@SerializedName("support")
	private SupportDTO support;

	public DataDTO getData(){
		return data;
	}

	public SupportDTO getSupport(){
		return support;
	}
}