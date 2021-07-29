package com.example.itunes;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<ResultsModel> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<ResultsModel> getResults(){
		return results;
	}
}