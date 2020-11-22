package com.wf.spring.ibs.model;

public class DebitCard {
	String AccNumber;
	String DCNumber;
	String BlockingType;
	String ActionType;
	String BlockingReason;
	String stmtcycle;
	int DebitCardCVV;
	int DebitCardPin;
	String DCType;
 String MismatchFile;
	public DebitCard() {

	}

	public String getMismatchFile() {
		return MismatchFile;
	}

	public void setMismatchFile(String mismatchFile) {
		MismatchFile = mismatchFile;
	}

	public String getDCType() {
		return DCType;
	}

	public void setDCType(String dCType) {
		DCType = dCType;
	}

	public int getDebitCardCVV() {
		return DebitCardCVV;
	}

	public void setDebitCardCVV(int debitCardCVV) {
		DebitCardCVV = debitCardCVV;
	}

	public int getDebitCardPin() {
		return DebitCardPin;
	}

	public void setDebitCardPin(int debitCardPin) {
		DebitCardPin = debitCardPin;
	}

	public String getStmtcycle() {
		return stmtcycle;
	}

	public void setStmtcycle(String stmtcycle) {
		this.stmtcycle = stmtcycle;
	}

	public String getAccNumber() {
		return AccNumber;
	}

	public void setAccNumber(String accNumber) {
		AccNumber = accNumber;
	}

	public String getDCNumber() {
		return DCNumber;
	}

	public void setDCNumber(String dCNumber) {
		DCNumber = dCNumber;
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

}
