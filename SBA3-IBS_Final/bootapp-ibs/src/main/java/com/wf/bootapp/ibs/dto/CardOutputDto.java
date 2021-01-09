package com.wf.bootapp.ibs.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class CardOutputDto {
	
	private Long cardNumber;
	private Long customerId;
	private String actionType;
	private  String cardType;
	private String mismatchFile;
	private String cardStatus;
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getactionType() {
		return actionType;
	}

	public void setactionType(String actionType) {
		this.actionType = actionType;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getMismatchFile() {
		return mismatchFile;
	}

	public void setMismatchFile(String mismatchFile) {
		this.mismatchFile = mismatchFile;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
	
}
