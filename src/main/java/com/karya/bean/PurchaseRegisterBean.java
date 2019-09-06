package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PurchaseRegisterBean {
	private int regId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the invoice")
	private String invoice;
	
	@NotNull
	 @NotEmpty(message = "Please mention the posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please mention the supplier")
	private String supName;
	
	@NotNull
	 @NotEmpty(message = "Please mention the supplier type")
	private String supType;
	
	@NotNull
	 @NotEmpty(message = "Please enter the account Type")
	private String accountType;
	
	@NotNull
	 @NotEmpty(message = "Please enter the payment mode")
	private String paymentMode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the project name")
	private String projectname;
	
	@NotNull
	 @NotEmpty(message = "Please enter the bill number")
	private String billNo;
	
	@NotNull
	 @NotEmpty(message = "Please mention the bill date")
	private String billDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the remarks")
	private String remarks;
	
	@NotNull
	 @NotEmpty(message = "Please enter the purchase order")
	private String poSeries;
	
	@NotNull
	 @NotEmpty(message = "Please enter the purchase receipt")
	private String purecpt;
	
	@NotNull
	 @NotEmpty(message = "Please enter currency")
	private String currency;
	
	
	private String furnituresCount;
	private String softwaresCount;
	private String stkrecBalance;
	private String netTotal;
	private String totalTax;
	private String grandTotal;
	private String roundTotal;
	private String outstandAmt;
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupType() {
		return supType;
	}
	public void setSupType(String supType) {
		this.supType = supType;
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
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPoSeries() {
		return poSeries;
	}
	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}
	public String getPurecpt() {
		return purecpt;
	}
	public void setPurecpt(String purecpt) {
		this.purecpt = purecpt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getFurnituresCount() {
		return furnituresCount;
	}
	public void setFurnituresCount(String furnituresCount) {
		this.furnituresCount = furnituresCount;
	}
	public String getSoftwaresCount() {
		return softwaresCount;
	}
	public void setSoftwaresCount(String softwaresCount) {
		this.softwaresCount = softwaresCount;
	}
	public String getStkrecBalance() {
		return stkrecBalance;
	}
	public void setStkrecBalance(String stkrecBalance) {
		this.stkrecBalance = stkrecBalance;
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
	public String getRoundTotal() {
		return roundTotal;
	}
	public void setRoundTotal(String roundTotal) {
		this.roundTotal = roundTotal;
	}
	public String getOutstandAmt() {
		return outstandAmt;
	}
	public void setOutstandAmt(String outstandAmt) {
		this.outstandAmt = outstandAmt;
	}
	
	
	

}
