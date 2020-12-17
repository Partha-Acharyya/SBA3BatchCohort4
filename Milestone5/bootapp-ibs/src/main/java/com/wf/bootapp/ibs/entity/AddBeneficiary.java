package com.wf.bootapp.ibs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AddBeneficiary {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   private Long beneficiaryAccountNo;
   private String beneficiaryAccountType;
   private String beneficiaryName;
   private String ifscCode; 
   private Long customerId ;
   private String status;
   
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public Long getBeneficiaryAccountNo() {
	return beneficiaryAccountNo;
}
public void setBeneficiaryAccountNo(Long beneficiaryAccountNo) {
	this.beneficiaryAccountNo = beneficiaryAccountNo;
}
public String getBeneficiaryAccountType() {
	return beneficiaryAccountType;
}
public void setBeneficiaryAccountType(String beneficiaryAccountType) {
	this.beneficiaryAccountType = beneficiaryAccountType;
}
public String getBeneficiaryName() {
	return beneficiaryName;
}
public void setBeneficiaryName(String beneficiaryName) {
	this.beneficiaryName = beneficiaryName;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
 


}
