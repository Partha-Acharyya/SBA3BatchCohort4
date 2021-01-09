package com.wf.bootapp.ibs.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class CardDto {
	@NotNull
	private Long cardNumber;
	
	private String blockingType;
	
	private String actionType;
	
	private String blockingReason;
	
	private String stmtCycle;
	@NotNull
	private int  cardCvv;
	@NotNull
	private int  cardPin;
	private Long customerID;
	private MultipartFile  file;
	private String  mismatchFile;
	private  String cardType;
	private String cardStatus;
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
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
	public int getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
	
	
}
