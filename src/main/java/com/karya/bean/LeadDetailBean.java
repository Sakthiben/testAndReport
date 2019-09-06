package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LeadDetailBean {
	private int leadId;
	@NotNull
	@NotEmpty(message = "Please enter the leadname")
	
	private String leadName;
	@NotNull
	@NotEmpty(message = "Please enter the company")
	
	private String companyName;
	@NotNull
	@NotEmpty(message = "Please select the status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please enter valid address")
	
	private String address;
	@NotNull
	@NotEmpty(message = "Please enter the state")
	
	private String state;
	@NotNull
	@NotEmpty(message = "Please specify the pincode")
	
	private String pinCode;
	@NotNull
	@NotEmpty(message = "Please enter the country")
	
	private String country;
	@NotNull
	@NotEmpty(message = "Please mention the phone number")
	
	private String phone;
	@NotNull
	@NotEmpty(message = "Please enter the mobile number")
	
	private String mobileNo;
	@NotNull
	@NotEmpty(message = "Please specify the email")
	
	private String email;
	@NotNull
	@NotEmpty(message = "Please enter the owner")
	
	private String leadOwner;
	@NotNull
	@NotEmpty(message = "Please select territory")
	
	private String terName;
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLeadOwner() {
		return leadOwner;
	}
	public void setLeadOwner(String leadOwner) {
		this.leadOwner = leadOwner;
	}
	public String getTerName() {
		return terName;
	}
	public void setTerName(String terName) {
		this.terName = terName;
	}
	
	
	

}
