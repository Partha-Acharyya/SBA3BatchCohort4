package com.wf.bootapp.ibs.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class CardStatementDto {
	private Long cardNumber;
	private String createDate;
	private String transactionType ; 
	@NotNull
	private Double amount ;
	@NotNull
	private String startDate;
	@NotNull
	private String endDate;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long CardNumber) {
		this.cardNumber = CardNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
//	public Date getCreateDate() {
//		return createDate;
//	}
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
}
