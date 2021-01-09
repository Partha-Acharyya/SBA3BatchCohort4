package com.wf.bootapp.ibs.dto;

public class ServiceProviderDto {
	private Long SPI;
	private String providerName;
	private String member1;
	private String member2;
	private double netWorth;
	private double expectedNetWorth;
	private String pan;
	private String currentAccountNumber;
	private String currentAcccountBranch;
	private String currentAcccountIfscCode;
	private String currentAcccountName;
	private String phoneNumber;
	private String status;
	public Long getSPI() {
		return SPI;
	}
	public void setSPI(Long sPI) {
		SPI = sPI;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getMember1() {
		return member1;
	}
	public void setMember1(String member1) {
		this.member1 = member1;
	}
	public String getMember2() {
		return member2;
	}
	public void setMember2(String member2) {
		this.member2 = member2;
	}
	public double getNetWorth() {
		return netWorth;
	}
	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}
	public double getExpectedNetWorth() {
		return expectedNetWorth;
	}
	public void setExpectedNetWorth(double expectedNetWorth) {
		this.expectedNetWorth = expectedNetWorth;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getCurrentAccountNumber() {
		return currentAccountNumber;
	}
	public void setCurrentAccountNumber(String currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}
	public String getCurrentAcccountBranch() {
		return currentAcccountBranch;
	}
	public void setCurrentAcccountBranch(String currentAcccountBranch) {
		this.currentAcccountBranch = currentAcccountBranch;
	}
	public String getCurrentAcccountIfscCode() {
		return currentAcccountIfscCode;
	}
	public void setCurrentAcccountIfscCode(String currentAcccountIfscCode) {
		this.currentAcccountIfscCode = currentAcccountIfscCode;
	}
	public String getCurrentAcccountName() {
		return currentAcccountName;
	}
	public void setCurrentAcccountName(String currentAcccountName) {
		this.currentAcccountName = currentAcccountName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}