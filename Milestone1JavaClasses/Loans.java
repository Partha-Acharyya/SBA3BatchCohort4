package SBA3;

public class Loans {
	private int LoadID;
	private String LoanType;
	private double Principal;
	private double InterestRate;
	private double Term;
	private Accounts AccountNumber;
	private Customer UCI;
	public int getLoadID() {
		return LoadID;
	}
	public void setLoadID(int loadID) {
		LoadID = loadID;
	}
	public String getLoanType() {
		return LoanType;
	}
	public void setLoanType(String loanType) {
		LoanType = loanType;
	}
	public double getPrincipal() {
		return Principal;
	}
	public void setPrincipal(double principal) {
		Principal = principal;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	public double getTerm() {
		return Term;
	}
	public void setTerm(double term) {
		Term = term;
	}
	public Accounts getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Accounts accountNumber) {
		AccountNumber = accountNumber;
	}
	public Customer getUCI() {
		return UCI;
	}
	public void setUCI(Customer uCI) {
		UCI = uCI;
	}
	public Loans(int loadID, String loanType, double principal, double interestRate, double term,
			Accounts accountNumber, Customer uCI) {
		super();
		LoadID = loadID;
		LoanType = loanType;
		Principal = principal;
		InterestRate = interestRate;
		Term = term;
		AccountNumber = accountNumber;
		UCI = uCI;
	}
	
	
	
	

}
