package com.wf.sba3.ibs.Entity;

public class Accounts {
	private Customer UCI;
	private int AccountNumber;
	private String AccountType;
	private double Balance;
	
	public Customer getUCI() {
		return UCI;
	}
	public void setUCI(Customer uCI) {
		UCI = uCI;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public Accounts(Customer uCI, int accountNumber, String accountType, double balance) {
		super();
		UCI = uCI;
		AccountNumber = accountNumber;
		AccountType = accountType;
		Balance = balance;
	}
	
	public void getStatement(){
		
	}

}
