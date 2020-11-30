package com.wf.bootapp.ibs.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class recurringDeposit {
	@Id
	@GeneratedValue
Long recurringDepositID;	
Double investmentAmount;
Long accountNumber;
int tenure;
int monthlyDebitDate;
Date maturityDate;
public Long getRecurringDepositID() {
	return recurringDepositID;
}
public void setRecurringDepositID(Long recurringDepositID) {
	this.recurringDepositID = recurringDepositID;
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

}
