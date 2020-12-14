package com.wf.bootapp.ibs.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class CardDto {
	@NotNull
	private Long CardNumber;
	
	private String blockingType;
	
	private String actionType;
	
	private String blockingReason;
	
	private String stmtCycle;
	@NotNull
	@Range(min = 3, max = 3)
	private int CardCVV;
	@NotNull
	@Range(min = 4, max = 4)
	private int CardPin;
	@NotNull
	private Long customerID;
	private String mismatchFile;
	
	public String getBlockingType() {
		return blockingType;
	}
	public void setBlockingType(String blockingType) {
		this.blockingType = blockingType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getBlockingReason() {
		return blockingReason;
	}
	public void setBlockingReason(String blockingReason) {
		this.blockingReason = blockingReason;
	}
	public String getStmtCycle() {
		return stmtCycle;
	}
	public void setStmtCycle(String stmtCycle) {
		this.stmtCycle = stmtCycle;
	}
	
	public Long getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		CardNumber = cardNumber;
	}
	public int getCardCVV() {
		return CardCVV;
	}
	public void setCardCVV(int cardCVV) {
		CardCVV = cardCVV;
	}
	public int getCardPin() {
		return CardPin;
	}
	public void setCardPin(int cardPin) {
		CardPin = cardPin;
	}
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	public String getMismatchFile() {
		return mismatchFile;
	}
	public void setMismatchFile(String mismatchFile) {
		this.mismatchFile = mismatchFile;
	}
	
}
