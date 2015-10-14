package com.bayviewglen.contacts;

import java.io.Serializable;

public class Contact implements Serializable{

	private String lname;
	private String fname;
	private String phone;
	
	

	public Contact(String lname, String fname, String phone) {
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
	}
	
	public void display(){
		
		System.out.printf("%1s%32s%1s%32s%1s%31s%1s\n", "|", fname, "|", lname, "|", phone, "|");
		System.out.println("----------------------------------------------------------------------------------------------------");
	
		
	}
	
	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	
	
	
	
	
	
	
}
