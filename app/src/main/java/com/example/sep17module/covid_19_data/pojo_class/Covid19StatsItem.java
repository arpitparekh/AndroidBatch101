package com.example.sep17module.covid_19_data.pojo_class;

import com.google.gson.annotations.SerializedName;

public class Covid19StatsItem{

	@SerializedName("country")
	private String country;

	@SerializedName("recovered")
	private Object recovered;

	@SerializedName("province")
	private String province;

	@SerializedName("city")
	private Object city;

	@SerializedName("lastUpdate")
	private String lastUpdate;

	@SerializedName("keyId")
	private String keyId;

	@SerializedName("confirmed")
	private int confirmed;

	@SerializedName("deaths")
	private int deaths;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setRecovered(Object recovered){
		this.recovered = recovered;
	}

	public Object getRecovered(){
		return recovered;
	}

	public void setProvince(String province){
		this.province = province;
	}

	public String getProvince(){
		return province;
	}

	public void setCity(Object city){
		this.city = city;
	}

	public Object getCity(){
		return city;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setKeyId(String keyId){
		this.keyId = keyId;
	}

	public String getKeyId(){
		return keyId;
	}

	public void setConfirmed(int confirmed){
		this.confirmed = confirmed;
	}

	public int getConfirmed(){
		return confirmed;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return

			"province = " + province +
			"\nlastUpdate = " + lastUpdate +
			"\nkeyId = " + keyId +
			"\nconfirmed = " + confirmed +
			",\ndeaths = " + deaths ;
		}
}