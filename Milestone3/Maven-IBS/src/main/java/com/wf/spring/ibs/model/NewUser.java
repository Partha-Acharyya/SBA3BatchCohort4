package com.wf.spring.ibs.model;

public class NewUser {
	private String ReferenceID;
	private String Name;
	private String Email;
	private int ContactNumber;
	private String Address;
	private String DOB;
	public String getName() {
		return Name;
	}
	
	
	public String getReferenceID() {
		return ReferenceID;
	}


	public void setReferenceID(String referenceID) {
		ReferenceID = referenceID;
	}


	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	

}
