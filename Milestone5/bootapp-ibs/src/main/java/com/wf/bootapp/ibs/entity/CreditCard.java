package com.wf.bootapp.ibs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CreditCard {

	@Id
	private Long Id;
	@Column(unique = true)
	private Long ccNumber;
	private String blockingType;
	private String actionType;
	private String blockingReason;
	private String stmtCycle;
	private int creditCardCVV;
	private int creditCardPin;
	private Long customerId;
	private String mismatchFile;

	public Long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Long ccNumber) {
		this.ccNumber = ccNumber;
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

	public int getCreditCardCVV() {
		return creditCardCVV;
	}

	public void setCreditCardCVV(int creditCardCVV) {
		this.creditCardCVV = creditCardCVV;
	}

	public int getCreditCardPin() {
		return creditCardPin;
	}

	public void setCreditCardPin(int creditCardPin) {
		this.creditCardPin = creditCardPin;
	}

	public String getMismatchFile() {
		return mismatchFile;
	}

	public void setMismatchFile(String mismatchFile) {
		this.mismatchFile = mismatchFile;
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
