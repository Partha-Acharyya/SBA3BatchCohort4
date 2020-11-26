package com.wf.spring.ibs.model;

public class LoanDto {
	
	private String type;
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private double income;
	private long number;
	private double emi;
	
	public String getType() {
		return type;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	public double getIncome() {
		return income;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public long getNumber() {
		return number;
	}
	public double getEmi() {
		return emi;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
}
