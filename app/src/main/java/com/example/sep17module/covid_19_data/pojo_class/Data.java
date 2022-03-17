package com.example.sep17module.covid_19_data.pojo_class;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("covid19Stats")
	private List<Covid19StatsItem> covid19Stats;

	@SerializedName("lastChecked")
	private String lastChecked;

	public void setCovid19Stats(List<Covid19StatsItem> covid19Stats){
		this.covid19Stats = covid19Stats;
	}

	public List<Covid19StatsItem> getCovid19Stats(){
		return covid19Stats;
	}

	public void setLastChecked(String lastChecked){
		this.lastChecked = lastChecked;
	}

	public String getLastChecked(){
		return lastChecked;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"covid19Stats = '" + covid19Stats + '\'' + 
			",lastChecked = '" + lastChecked + '\'' + 
			"}";
		}
}