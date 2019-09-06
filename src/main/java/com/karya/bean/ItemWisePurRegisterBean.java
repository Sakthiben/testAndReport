package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemWisePurRegisterBean {
	private int iwprId;
	
	@NotNull
	 @NotEmpty(message = "Please select the item")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please select the item group")
	private String itemGroup;
	
	@NotNull
	 @NotEmpty(message = "Please enter the invoice")
	private String inVoice;
	
	@NotNull
	 @NotEmpty(message = "Please mention posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please select the supplier name")
	private String supName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the payable account")
	private String payAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter the mode of payment")
	private String paymentMode;
	
	@NotNull
	 @NotEmpty(message = "Please select the project")
	private String projectname;
	
	@NotNull
	 @NotEmpty(message = "Please enter the company")
	private String company;
	
	@NotNull
	 @NotEmpty(message = "Please select the purchase order")
	private String poSeries;
	
	@NotNull
	 @NotEmpty(message = "Please select the purchase receipt")
	private String purtName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the expense account")
	private String expenseAccount;
	
	@NotNull
	 @NotEmpty(message = "Please mention quantity")
	private String quantity;
	
	@NotNull
	 @NotEmpty(message = "Please enter the rate")
	private String rate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the amount")
	private String amount;
	
	@NotNull
	 @NotEmpty(message = "Please mention tax if applicable")
	private String totalTax;
	
	@NotNull
	 @NotEmpty(message = "Please enter the total")
	private String total;
	
	@NotNull
	 @NotEmpty(message = "Please select the currency type")
	private String currency;
	public int getIwprId() {
		return iwprId;
	}
	public void setIwprId(int iwprId) {
		this.iwprId = iwprId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	public String getInVoice() {
		return inVoice;
	}
	public void setInVoice(String inVoice) {
		this.inVoice = inVoice;
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
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPoSeries() {
		return poSeries;
	}
	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}
	public String getPurtName() {
		return purtName;
	}
	public void setPurtName(String purtName) {
		this.purtName = purtName;
	}
	public String getExpenseAccount() {
		return expenseAccount;
	}
	public void setExpenseAccount(String expenseAccount) {
		this.expenseAccount = expenseAccount;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	public String getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	

}
