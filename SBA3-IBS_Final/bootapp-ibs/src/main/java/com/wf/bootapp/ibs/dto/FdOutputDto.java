package com.wf.bootapp.ibs.dto;

import java.util.Date;

public class FdOutputDto {
	Long fixedDepositID;
	Double investmentAmount;
	Long accountNumber;
	int tenure;
	Date maturityDate;
	public Long getFixedDepositID() {
		return fixedDepositID;
	}
	public void setFixedDepositID(Long fixedDepositID) {
		this.fixedDepositID = fixedDepositID;
	}
	public Double getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(Double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}


}
