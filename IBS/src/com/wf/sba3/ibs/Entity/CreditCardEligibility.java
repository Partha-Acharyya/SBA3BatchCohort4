package com.wf.sba3.ibs.Entity;

import java.util.Date;
import java.util.UUID;

public class CreditCardEligibility {
	private static String ReferenceID;
	private static String FirstName;
	private static String LastName;
	private static long MobileNumber;
	private static String TypeOfEmployment;
	private  static String TotalIncome;
	private static String Email;
	private static String birthday;

	public CreditCardEligibility(String firstName, String lastName, long mobileNumber, String typeOfEmployment,
			String totalIncome, String email, String birthday) {
		super();
		FirstName = firstName;
		LastName = lastName;
		MobileNumber = mobileNumber;
		TypeOfEmployment = typeOfEmployment;
		TotalIncome = totalIncome;
		Email = email;
		CreditCardEligibility.birthday =  birthday;
	}
	
	public static String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public static String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public static long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public static String getTypeOfEmployment() {
		return TypeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		TypeOfEmployment = typeOfEmployment;
	}

	public static String getTotalIncome() {
		return TotalIncome;
	}

	public void setTotalIncome(String totalIncome) {
		TotalIncome = totalIncome;
	}

	public static  String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public static String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		CreditCardEligibility.birthday = birthday;
	}

	public static String getReferenceID() {
		 String ReferenceID = "";
		 try {
		 UUID uuid = UUID.randomUUID();
		 ReferenceID = uuid.toString();
		 } 
		 catch (Exception e) {
		 e.printStackTrace();
		 }
		return ReferenceID;
	}

	public static void setReferenceID(String referenceID) {
		ReferenceID = referenceID;
	}
	
}
