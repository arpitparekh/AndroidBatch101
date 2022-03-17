package com.example.sep17module.retrofit_local_server_xampp;

import com.google.gson.annotations.SerializedName;

public class Student{

	@SerializedName("mobile_no")
	private String mobileNo;

	@SerializedName("id")
	private String id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}

	public String getMobileNo(){
		return mobileNo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return
				"id = " + id +
						"\nfirst_name = " + firstName +
						"\nemail = " + email +
			"\nmobile_no = " + mobileNo ;



		}
}