package com.wf.bootapp.ibs.dto;

import java.sql.Date;

public class rdInputDto {

	Double investmentAmount;
	Long accountNumber;
	int tenure;
	int monthlyDebitDate;
	Date maturityDate;

	public Double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(Double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public int getMonthlyDebitDate() {
		return monthlyDebitDate;
	}

	public void setMonthlyDebitDate(int monthlyDebitDate) {
		this.monthlyDebitDate = monthlyDebitDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
}
