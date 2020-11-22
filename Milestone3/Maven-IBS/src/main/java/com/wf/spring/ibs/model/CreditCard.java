package com.wf.spring.ibs.model;

import java.util.Date;
import java.util.UUID;

public class CreditCard {

	private String FirstName;
	private String LastName;
	private long MobileNumber;
	private String ReferenceID;
	private String TypeOfEmployment;
	private String TotalIncome;
	private String Email;
	private String birthday;
	private String CCType;
	private String CCNumber;
	private String BlockingType;
	private String ActionType;
	private String BlockingReason;
	private String stmtcycle;
	private int CreditCardCVV;
	private int CreditCardPin;
	String AccNumber;
	String MismatchFile;

	public CreditCard(String firstName, String lastName, long mobileNumber, String typeOfEmployment, String totalIncome,
			String email, String birthday) {
		super();
		FirstName = firstName;
		LastName = lastName;
		MobileNumber = mobileNumber;
		TypeOfEmployment = typeOfEmployment;
		TotalIncome = totalIncome;
		Email = email;
		this.birthday = birthday;
	}

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String accNumber) {
		AccNumber = accNumber;
	}

	public String getCCType() {
		return CCType;
	}

	public void setCCType(String cCType) {
		CCType = cCType;
	}

	public String getFirstName() {
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

	public void setReferenceID(String referenceID) {
		this.ReferenceID = referenceID;
	}

	public String getCCNumber() {
		return CCNumber;
	}

	public void setCCNumber(String cCNumber) {
		CCNumber = cCNumber;
	}

	public String getBlockingType() {
		return BlockingType;
	}

	public void setBlockingType(String blockingType) {
		BlockingType = blockingType;
	}

	public String getActionType() {
		return ActionType;
	}

	public void setActionType(String actionType) {
		ActionType = actionType;
	}

	public String getBlockingReason() {
		return BlockingReason;
	}

	public void setBlockingReason(String blockingReason) {
		BlockingReason = blockingReason;
	}

	public String getStmtcycle() {
		return stmtcycle;
	}

	public void setStmtcycle(String stmtcycle) {
		this.stmtcycle = stmtcycle;
	}

	public int getCreditCardCVV() {
		return CreditCardCVV;
	}

	public void setCreditCardCVV(int creditCardCVV) {
		CreditCardCVV = creditCardCVV;
	}

	public int getCreditCardPin() {
		return CreditCardPin;
	}

	public void setCreditCardPin(int creditCardPin) {
		CreditCardPin = creditCardPin;
	}

	public String getMismatchFile() {
		return MismatchFile;
	}

	public void setMismatchFile(String mismatchFile) {
		MismatchFile = mismatchFile;
	}

}
