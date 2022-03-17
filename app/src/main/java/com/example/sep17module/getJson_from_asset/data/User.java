package com.example.sep17module.getJson_from_asset.data;

import java.util.List;

public class User{

	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}