package com.wf.bootapp.ibs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class DebitCardStatement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long debitCardNumber;
//	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
	private String createDate;
	private String transactionType ; 
	private Double amount ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	//
//	public Date getCreateDate() {
//		return createDate;
//	}
//	@PrePersist
//	public void setCreateDate() {
//		this.createDate = new Date();
//	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getDebitCardNumber() {
		return debitCardNumber;
	}
	public void setDebitCardNumber(Long debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

}
