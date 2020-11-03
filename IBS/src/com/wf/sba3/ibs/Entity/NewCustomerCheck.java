package com.wf.sba3.ibs.Entity;

import java.util.UUID;

public class NewCustomerCheck {
	private int ReferenceID;
	private String Name;
	private String email;
	private String contact;
	private String Address;
	private String Date;
	
	public int getReferenceID() {
		return ReferenceID;
	}
//	public void setReferenceID(int referenceID) {
//		ReferenceID = referenceID;
//	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public NewCustomerCheck(String name, String email, String contact, String address, String date) {
		super();
		ReferenceID = 100+(int)(Math.random()*(50-30)+1);
		Name = name;
		this.email = email;
		this.contact = contact;
		Address = address;
		Date = date;
	}
	
	
	
}
