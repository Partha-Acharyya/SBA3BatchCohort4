package com.wf.bootapp.ibs.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class account {
	@Id
 Long accountNumber;

 Long customerId;
 char accountType ; 
 double balance   ;
 
 public account() {
	
}

public Long getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}

public Long getCustomerId() {
	return customerId;
}

public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}

public char getAccountType() {
	return accountType;
}

public void setAccountType(char accountType) {
	this.accountType = accountType;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
 
 
}
