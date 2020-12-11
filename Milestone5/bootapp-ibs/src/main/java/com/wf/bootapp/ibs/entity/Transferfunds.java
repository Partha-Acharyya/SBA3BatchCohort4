package com.wf.bootapp.ibs.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Transferfunds {
	@Id
 int accountNumber;
 Long customerId;
 char transType ; 
 double amount   ;
 
 
 public Transferfunds() {
	
}

public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}

public char getTransType() {
	return transType;
}

public void setTransType(String transtype) {
	this.transType = transType;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}
 
 
}
