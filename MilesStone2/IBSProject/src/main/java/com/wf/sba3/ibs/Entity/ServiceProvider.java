package com.wf.sba3.ibs.Entity;

import java.util.Date;

public class ServiceProvider {
	private int SPI;
	private int SPIAccount;
	private String Name;
	private String Address;
	private int Phone;
	private String BankName;
	private String Details;
	private Date DOB;
	private Accounts AccountNumber;
	public int getSPI() {
		return SPI;
	}
	public void setSPI(int sPI) {
		SPI = sPI;
	}
	public int getSPIAccount() {
		return SPIAccount;
	}
	public void setSPIAccount(int sPIAccount) {
		SPIAccount = sPIAccount;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Accounts getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Accounts accountNumber) {
		AccountNumber = accountNumber;
	}
	public ServiceProvider(int sPI, int sPIAccount, String name, String address, int phone, String bankName,
			String details, Date dOB, Accounts accountNumber) {
		super();
		SPI = sPI;
		SPIAccount = sPIAccount;
		Name = name;
		Address = address;
		Phone = phone;
		BankName = bankName;
		Details = details;
		DOB = dOB;
		AccountNumber = accountNumber;
	}
	
	

}
