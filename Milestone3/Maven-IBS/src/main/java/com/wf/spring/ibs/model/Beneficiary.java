package com.wf.spring.ibs.model;

public class Beneficiary {
	
	private int BeneficiaryAccount;
	private String BeneficiaryName;
	private String BeneficiaryAccountType;
	private String Limit;
	private String IFSCCode;
	private String UCI;
	
	public Beneficiary(int beneficiaryAccount, String beneficiaryName, String Limit, String beneficiaryAccountType,
			String iFSCCode, String uCI) {
		super();
		BeneficiaryAccount = beneficiaryAccount;
		BeneficiaryName = beneficiaryName;
		BeneficiaryAccountType = beneficiaryAccountType;
		Limit = this.Limit; 
		IFSCCode = iFSCCode;
		UCI = uCI;
	}
	
	public Beneficiary() {
		
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
	public String getBeneficiaryAccountType() {
		return BeneficiaryAccountType;
	}
	public void setBeneficiaryAccountType(String beneficiaryAccountType) {
		BeneficiaryAccountType = beneficiaryAccountType;
	}

	
	public String getLimit() { 
		return Limit; 
	} 
	public void setLimit(String limit) { 
		Limit = limit; 
	}
	 
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public String getUCI() {
		return UCI;
	}
	public void setUCI(String uCI) {
		UCI = uCI;
	}
	
	
	
	
	

}
