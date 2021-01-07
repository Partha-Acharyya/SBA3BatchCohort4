package com.wf.bootapp.ibs.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


public class Newuser {
	@NotBlank(message = "First Name is required!")
	private String firstName;
	@NotBlank(message = "Last Name is required!")
	private String lastName;
	@Email
	private String email;
	@Range(max = 10, min = 10)
	private Long mobileNumber;
	private String city;
	private String birthday;
	private String location;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
