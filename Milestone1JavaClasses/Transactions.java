package SBA3;

import java.util.Date;

public class Transactions {
	
	private Accounts AccountNumber;
	private int TransactionID;
	private Date DateTransaction;
	private double ClosingAccountBalance;
	private String TransactionType;
	public Accounts getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Accounts accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public Date getDateTransaction() {
		return DateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		DateTransaction = dateTransaction;
	}
	public double getClosingAccountBalance() {
		return ClosingAccountBalance;
	}
	public void setClosingAccountBalance(double closingAccountBalance) {
		ClosingAccountBalance = closingAccountBalance;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	
	public Transactions(Accounts accountNumber, int transactionID, Date dateTransaction, double closingAccountBalance,
			String transactionType) {
		super();
		AccountNumber = accountNumber;
		TransactionID = transactionID;
		DateTransaction = dateTransaction;
		ClosingAccountBalance = closingAccountBalance;
		TransactionType = transactionType;
	}
	
	

}
