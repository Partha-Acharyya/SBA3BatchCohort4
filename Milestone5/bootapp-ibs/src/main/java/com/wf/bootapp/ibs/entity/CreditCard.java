package com.wf.bootapp.ibs.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class CreditCard {

	
	@NotEmpty
	@Column(unique = true)
	private Long CCNumber;
	private String BlockingType;
	private String ActionType;
	private String BlockingReason;
	private String stmtcycle;
	@Length(min = 3, max = 3)
	private int CreditCardCVV;
	@Length(min = 4, max = 4)
	private int CreditCardPin;
	private Long CustomerID;
	private String MismatchFile;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

//	public String getCCType() {
//		return CCType;
//	}
//
//	public void setCCType(String cCType) {
//		CCType = cCType;
//	}

	public Long getCCNumber() {
		return CCNumber;
	}

	public void setCCNumber(Long cCNumber) {
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

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public String getMismatchFile() {
		return MismatchFile;
	}

	public void setMismatchFile(String mismatchFile) {
		MismatchFile = mismatchFile;
	}

}
