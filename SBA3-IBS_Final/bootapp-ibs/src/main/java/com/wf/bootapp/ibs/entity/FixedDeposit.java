package com.wf.bootapp.ibs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class FixedDeposit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fixedDepositID;
	private Long customerId;
	private Double investmentAmount;
	private Long accountNumber;
	private int tenure;
	private Date maturityDate;
	public Long getFixedDepositID() {
		return fixedDepositID;
	}
	public void setFixedDepositID(Long fixedDepositID) {
		this.fixedDepositID = fixedDepositID;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
