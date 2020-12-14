package com.wf.bootapp.ibs.dto;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

public class CreditCardEligibilityOutputDto {

	private Long referenceID;
	private long mobileNumber;
	private String firstName;
	private String lastName;
	private String status;
	private String typeOfEmployment;
	private String totalIncome;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(Long referenceID) {
		this.referenceID = referenceID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
