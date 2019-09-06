package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BankClearanceBean {
	private int bankclrId;
	
	@NotNull
	 @NotEmpty(message = "Please mention from date")
	private String fromDate;
	
	@NotNull
	 @NotEmpty(message = "Please mention to date")
	private String toDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the bank account")
	private String bankAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter the payment document")
	private String payDocument;
	
	@NotNull
	 @NotEmpty(message = "Please enter the payment entry")
	private String entrySeries;
	
	@NotNull
	 @NotEmpty(message = "Please enter cheque reference")
	private String chequeref;
	
	@NotNull
	 @NotEmpty(message = "Please enter the clearance date")
	private String clearanceDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the against account")
	private String againstAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter the amount")
	private String amount;
	public int getBankclrId() {
		return bankclrId;
	}
	public void setBankclrId(int bankclrId) {
		this.bankclrId = bankclrId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPayDocument() {
		return payDocument;
	}
	public void setPayDocument(String payDocument) {
		this.payDocument = payDocument;
	}
	public String getEntrySeries() {
		return entrySeries;
	}
	public void setEntrySeries(String entrySeries) {
		this.entrySeries = entrySeries;
	}
	public String getChequeref() {
		return chequeref;
	}
	public void setChequeref(String chequeref) {
		this.chequeref = chequeref;
	}
	public String getClearanceDate() {
		return clearanceDate;
	}
	public void setClearanceDate(String clearanceDate) {
		this.clearanceDate = clearanceDate;
	}
	public String getAgainstAccount() {
		return againstAccount;
	}
	public void setAgainstAccount(String againstAccount) {
		this.againstAccount = againstAccount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	

}
