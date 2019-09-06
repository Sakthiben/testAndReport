package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BankReconcileBean {
	
	private int bankrecId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the bank account")
	private String bankAccount;
	
	@NotNull
	 @NotEmpty(message = "Please mention the posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the payment entry")
	private String entrySeries;
	
	@NotNull
	 @NotEmpty(message = "Please enter debit")
	private String debit;
	
	@NotNull
	 @NotEmpty(message = "Please enter credit")
	private String credit;
	
	@NotNull
	 @NotEmpty(message = "Please enter the against account")
	private String againstAccount;
	
	@NotNull
	 @NotEmpty(message = "Please enter the reference name")
	private String referenceName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the reference date")
	private String referenceDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the clearance date")
	private String clearanceDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the currency")
	private String currency;
	public int getBankrecId() {
		return bankrecId;
	}
	public void setBankrecId(int bankrecId) {
		this.bankrecId = bankrecId;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getEntrySeries() {
		return entrySeries;
	}
	public void setEntrySeries(String entrySeries) {
		this.entrySeries = entrySeries;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getAgainstAccount() {
		return againstAccount;
	}
	public void setAgainstAccount(String againstAccount) {
		this.againstAccount = againstAccount;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}
	public String getClearanceDate() {
		return clearanceDate;
	}
	public void setClearanceDate(String clearanceDate) {
		this.clearanceDate = clearanceDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	

}
