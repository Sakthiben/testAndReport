package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companyaccount001mb")
public class CompanyAccounts001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "caId")
	private int caId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="country")
	private String country;
	
	@Column(name="abbreviation")
	private String abbreviation;
	
	@Column(name="companyDomain")
	private String companyDomain;
	
	@Column(name="defholList")
	private String defholList;
	
	@Column(name="defCurrency")
	private String defCurrency;
	
	@Column(name="accchartType")
	private String accchartType;
	
	@Column(name="defbankAccount")
	private String defbankAccount;
	
	@Column(name="defcashAccount")
	private String defcashAccount;
	
	@Column(name="defpayAccount")
	private String defpayAccount;
	
	@Column(name="defincomeAccount")
	private String defincomeAccount;
	
	@Column(name="rndoffCenter")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
