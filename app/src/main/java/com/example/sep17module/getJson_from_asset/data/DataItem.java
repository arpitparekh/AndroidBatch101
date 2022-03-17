package com.example.sep17module.getJson_from_asset.data;

public class DataItem{
	private Address address;
	private String name;
	private String age;

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"address = '" + address + '\'' + 
			",name = '" + name + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}
