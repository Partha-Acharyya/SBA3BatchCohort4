package com.wf.bootapp.ibs.dto;

//import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreditCardEligibilityInputDto {

	@NotEmpty
	@Length(min=3 , max=50)
	private String firstName;
	@NotEmpty
	@Length(min=3 , max=50)
	private String lastName;
	@NotNull
	//@Length(min=10 , max=10)
	private long mobileNumber;
	private String typeOfEmployment;
	private String totalIncome;
	@Email
	private String email;
	private String birthday;
	private  String ccType;

	public CreditCardEligibilityInputDto() {
		// TODO Auto-generated constructor stub
	}



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


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}


	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}


	public String getTotalIncome() {
		return totalIncome;
	}


	public void setTotalIncome(String totalIncome) {
		this.totalIncome = totalIncome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getCcType() {
		return ccType;
	}



	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

//	public static String getReferenceID() {
//		String ReferenceID = "";
//		try {
//			UUID uuid = UUID.randomUUID();
//			ReferenceID = uuid.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ReferenceID;
//	}

	

}
