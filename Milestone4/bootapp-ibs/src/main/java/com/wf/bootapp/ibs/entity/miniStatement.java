package com.wf.bootapp.ibs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class miniStatement {
@Id
 int id;
 Long custId;
 String createDate;
 char transType ; 
 double amount ;
 
 public miniStatement() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Long getCustId() {
	return custId;
}

public void setCustId(Long custId) {
	this.custId = custId;
}

public char getTransType() {
	return transType;
}

public void setTransType(char transType) {
	this.transType = transType;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getCreateDate() {
	return createDate;
}

public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
 
 
}
