package com.wf.bootapp.ibs.dto;

//import java.util.Date;
import java.util.UUID;

public class CreditCardInputDto {

	private String FirstName;
	private String LastName;
	private long MobileNumber;	
	private String TypeOfEmployment;
	private String TotalIncome;
	private String Email;
	private String birthday;
	private  String CCType;



	public CreditCardInputDto() {
		// TODO Auto-generated constructor stub
	}


	public  String getCCType() {
		return CCType;
	}

	public void setCCType(String cCType) {
		CCType = cCType;
	}

	public  String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getTypeOfEmployment() {
		return TypeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		TypeOfEmployment = typeOfEmployment;
	}

	public String getTotalIncome() {
		return TotalIncome;
	}

	public void setTotalIncome(String totalIncome) {
		TotalIncome = totalIncome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public static String getReferenceID() {
		String ReferenceID = "";
		try {
			UUID uuid = UUID.randomUUID();
			ReferenceID = uuid.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReferenceID;
	}

	

}
