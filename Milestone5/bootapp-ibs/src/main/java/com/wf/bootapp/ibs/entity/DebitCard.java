package com.wf.bootapp.ibs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DebitCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private Long cardNumber;
	private String blockingType;
	private String actionType;
	private String blockingReason;
	private String stmtCycle;
	private int cardCvv;
	private int cardPin;
	private Long customerId;
	private String mismatchFile;
	private  String dcType;
	private String cardStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getMismatchFile() {
		return mismatchFile;
	}
	public void setMismatchFile(String mismatchFile) {
		this.mismatchFile = mismatchFile;
	}
	public String getDcType() {
		return dcType;
	}
	public void setDcType(String dcType) {
		this.dcType = dcType;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

}
