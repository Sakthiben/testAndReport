package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CompanyAccountsBean {
	
	private int caId;
	
	@NotNull
	 @NotEmpty(message = "Please enter company")
	private String companyName;
	
	@NotNull
	 @NotEmpty(message = "Please enter country")
	private String country;
	
	@NotNull
	 @NotEmpty(message = "Please enter abbr")
	private String abbreviation;
	
	@NotNull
	 @NotEmpty(message = "Please enter domain")
	private String companyDomain;
	
	@NotNull
	 @NotEmpty(message = "Please enter default hoilday list")
	private String defholList;
	
	@NotNull
	 @NotEmpty(message = "Please enter defualt currency")
	private String defCurrency;
	
	@NotNull
	 @NotEmpty(message = "Please select account chart type")
	private String accchartType;
	
	@NotNull
	 @NotEmpty(message = "Please enter default bank account")
	private String defbankAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter defualt cash account")
	private String defcashAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter default payable account")
	private String defpayAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter default income account")
	private String defincomeAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter round off center")
	private String rndoffCenter;
	public int getCaId() {
		return caId;
	}
	public void setCaId(int caId) {
		this.caId = caId;
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
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCompanyDomain() {
		return companyDomain;
	}
	public void setCompanyDomain(String companyDomain) {
		this.companyDomain = companyDomain;
	}
	public String getDefholList() {
		return defholList;
	}
	public void setDefholList(String defholList) {
		this.defholList = defholList;
	}
	public String getDefCurrency() {
		return defCurrency;
	}
	public void setDefCurrency(String defCurrency) {
		this.defCurrency = defCurrency;
	}
	public String getAccchartType() {
		return accchartType;
	}
	public void setAccchartType(String accchartType) {
		this.accchartType = accchartType;
	}
	public String getDefbankAccount() {
		return defbankAccount;
	}
	public void setDefbankAccount(String defbankAccount) {
		this.defbankAccount = defbankAccount;
	}
	public String getDefcashAccount() {
		return defcashAccount;
	}
	public void setDefcashAccount(String defcashAccount) {
		this.defcashAccount = defcashAccount;
	}
	public String getDefpayAccount() {
		return defpayAccount;
	}
	public void setDefpayAccount(String defpayAccount) {
		this.defpayAccount = defpayAccount;
	}
	public String getDefincomeAccount() {
		return defincomeAccount;
	}
	public void setDefincomeAccount(String defincomeAccount) {
		this.defincomeAccount = defincomeAccount;
	}
	public String getRndoffCenter() {
		return rndoffCenter;
	}
	public void setRndoffCenter(String rndoffCenter) {
		this.rndoffCenter = rndoffCenter;
	}
	
	

}
