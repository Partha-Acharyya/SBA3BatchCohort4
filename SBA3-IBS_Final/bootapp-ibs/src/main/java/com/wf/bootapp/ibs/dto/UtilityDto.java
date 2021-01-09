package com.wf.bootapp.ibs.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class UtilityDto {

	@NotNull
	private double amount;
	@NotEmpty
	private String operator;
	@NotNull
	@Size(min=10, max=10, message=ValidationMessages.COLLECTION_SIZE)
	private String mobileNumber;
	@NotEmpty
	private String transactionPassword;
	private Long accountNumber;
	private String message;
	private String USCNo;

	public final class ValidationMessages {
		  public static final String COLLECTION_SIZE = 
		      "MobileNumber must be 10 digits";
		}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUSCNo() {
		return USCNo;
	}

	public void setUSCNo(String uSCNo) {
		USCNo = uSCNo;
	}
}
