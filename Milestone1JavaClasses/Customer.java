package SBA3;

import java.util.Date;

public class Customer {

	private int UCI;
	private String Name;
	private String Address;
	private int Phone;
	private String BranchName;
	private String Details;
	private String Email;
	private Date DOB;
	public int getUCI() {
		return UCI;
	}
	public void setUCI(int uCI) {
		UCI = uCI;
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
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Customer(int uCI, String name, String address, int phone, String branchName, String details, String email,
			Date dOB) {
		super();
		UCI = uCI;
		Name = name;
		Address = address;
		Phone = phone;
		BranchName = branchName;
		Details = details;
		Email = email;
		DOB = dOB;
	}
	
	

}
