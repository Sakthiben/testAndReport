package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emailsignature001mb")
public class EmailSignature001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emailSignatureId")
	private int emailSignatureId;
	
	@Column(name = "employeeId")
	private int employeeId;
	
	@Column(name="employeeNamePrefix")
	private String employeeNamePrefix;
	
	@Column(name="employeeName")
	private String employeeName;
	
	@Column(name="employeeDesignation")
	private String employeeDesignation;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="country")
	private String country;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="mobileNumber")
	private String mobileNumber;
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="companyWebsite")
	private String companyWebsite;
	
	@Column(name="logoLink")
	private String logoLink;

	public int getEmailSignatureId() {
		return emailSignatureId;
	}

	public void setEmailSignatureId(int emailSignatureId) {
		this.emailSignatureId = emailSignatureId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNamePrefix() {
		return employeeNamePrefix;
	}

	public void setEmployeeNamePrefix(String employeeNamePrefix) {
		this.employeeNamePrefix = employeeNamePrefix;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getLogoLink() {
		return logoLink;
	}

	public void setLogoLink(String logoLink) {
		this.logoLink = logoLink;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
