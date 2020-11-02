package SBA3;

public class Beneficiary {
	
	private int BeneficiaryAccount;
	private String BeneficiaryName;
	private int CreditCardNumber;
	private String BeneficiaryBankName;
	private String IFSCCode;
	private Customer UCI;
	
	public Beneficiary(int beneficiaryAccount, String beneficiaryName, int creditCardNumber, String beneficiaryBankName,
			String iFSCCode, Customer uCI) {
		super();
		BeneficiaryAccount = beneficiaryAccount;
		BeneficiaryName = beneficiaryName;
		CreditCardNumber = creditCardNumber;
		BeneficiaryBankName = beneficiaryBankName;
		IFSCCode = iFSCCode;
		UCI = uCI;
	}
	public int getBeneficiaryAccount() {
		return BeneficiaryAccount;
	}
	public void setBeneficiaryAccount(int beneficiaryAccount) {
		BeneficiaryAccount = beneficiaryAccount;
	}
	public String getBeneficiaryName() {
		return BeneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		BeneficiaryName = beneficiaryName;
	}
	public int getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public String getBeneficiaryBankName() {
		return BeneficiaryBankName;
	}
	public void setBeneficiaryBankName(String beneficiaryBankName) {
		BeneficiaryBankName = beneficiaryBankName;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public Customer getUCI() {
		return UCI;
	}
	public void setUCI(Customer uCI) {
		UCI = uCI;
	}
	
	
	

}
