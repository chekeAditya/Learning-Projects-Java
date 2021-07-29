package com.example.postrequest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("email")
	private String email;

	@SerializedName("password")
	private String password;

	@SerializedName("title")
	private String title;

	@SerializedName("requestType")
	private String requestType;

	@SerializedName("id")
	private int id;

	public String getEmail(){
		return email;
	}

	public String getPassword(){
		return password;
	}

	public String getTitle(){
		return title;
	}

	public String getRequestType(){
		return requestType;
	}

	public int getId(){
		return id;
	}
}