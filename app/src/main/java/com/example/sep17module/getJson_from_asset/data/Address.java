package com.example.sep17module.getJson_from_asset.data;

public class Address{
	private String stage;
	private String city;
	private String population;

	public void setStage(String stage){
		this.stage = stage;
	}

	public String getStage(){
		return stage;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPopulation(String population){
		this.population = population;
	}

	public String getPopulation(){
		return population;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"stage = '" + stage + '\'' + 
			",city = '" + city + '\'' + 
			",population = '" + population + '\'' + 
			"}";
		}
}
