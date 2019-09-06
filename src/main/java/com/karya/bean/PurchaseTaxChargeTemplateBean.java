package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PurchaseTaxChargeTemplateBean {
	
	private int putaxId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the status")
	private String status;
	
	@NotNull
	 @NotEmpty(message = "Please enter the company")
	private String company;
	
	@NotNull
	 @NotEmpty(message = "Please enter the tax charge type")
	private String taxchgType;
	
	@NotNull
	 @NotEmpty(message = "Please enter the account head")
	private String accountHead;
	
	private String rate;
	
	private String amount;
	
	private String total;
	public int getPutaxId() {
		return putaxId;
	}
	public void setPutaxId(int putaxId) {
		this.putaxId = putaxId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTaxchgType() {
		return taxchgType;
	}
	public void setTaxchgType(String taxchgType) {
		this.taxchgType = taxchgType;
	}
	public String getAccountHead() {
		return accountHead;
	}
	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
