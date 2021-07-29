package com.example.getresourcesapi.Model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SupportModel implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public String getUrl(){
		return url;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SupportModel{" + 
			"url = '" + url + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}