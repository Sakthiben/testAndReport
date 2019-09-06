package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SalesRegisterBean {
	
	private int regId;
	
	@NotNull
	 @NotEmpty(message = "Please mention the posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the customer name")
	private String customername;
	
	@NotNull
	 @NotEmpty(message = "Please enter the customer group")
	private String customergroup;
	
	@NotNull
	 @NotEmpty(message = "Please select the territory")
	private String terName;
	
	@NotNull
	 @NotEmpty(message = "Please select the account type")
	private String accountType;
	
	@NotNull
	 @NotEmpty(message = "Please select the payment mode")
	private String paymentMode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the project")
	private String projectname;
	
	@NotNull
	 @NotEmpty(message = "Please enter the remarks")
	private String remarks;
	
	@NotNull
	 @NotEmpty(message = "Please enter the sales code")
	private String salesCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the delivery note")
	private String delNote;
	
	@NotNull
	 @NotEmpty(message = "Please select the currency")
	private String currency;
	
	private String gainloss;
	private String saleswpl;
	private String netTotal;
	private String totalTax;
	private String grandTotal;
	private String roundedTotal;
	private String outstandAmt;
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomergroup() {
		return customergroup;
	}
	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}
	public String getTerName() {
		return terName;
	}
	public void setTerName(String terName) {
		this.terName = terName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	public String getDelNote() {
		return delNote;
	}
	public void setDelNote(String delNote) {
		this.delNote = delNote;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getGainloss() {
		return gainloss;
	}
	public void setGainloss(String gainloss) {
		this.gainloss = gainloss;
	}
	public String getSaleswpl() {
		return saleswpl;
	}
	public void setSaleswpl(String saleswpl) {
		this.saleswpl = saleswpl;
	}
	public String getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(String netTotal) {
		this.netTotal = netTotal;
	}
	public String getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getRoundedTotal() {
		return roundedTotal;
	}
	public void setRoundedTotal(String roundedTotal) {
		this.roundedTotal = roundedTotal;
	}
	public String getOutstandAmt() {
		return outstandAmt;
	}
	public void setOutstandAmt(String outstandAmt) {
		this.outstandAmt = outstandAmt;
	}
	
	
	

}
