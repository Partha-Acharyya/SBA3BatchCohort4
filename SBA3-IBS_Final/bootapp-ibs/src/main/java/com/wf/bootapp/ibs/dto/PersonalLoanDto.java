package com.wf.bootapp.ibs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "personal_Loan")
public class PersonalLoanDto {
	private Long id;
	//private String type;
	@NotEmpty
	@Size(min=6, max=50, message="please enter firstname")
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private double income;
	//private long number;
	//private double emi;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 10)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public String getType() { return type; }
	 */
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	public double getIncome() {
		return income;
	}

	/*
	 * public void setType(String type) { this.type = type; }
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	/*
	 * public long getNumber() { return number; } public double getEmi() { return
	 * emi; } public void setNumber(long number) { this.number = number; } public
	 * void setEmi(double emi) { this.emi = emi; }
	 */
	
}
