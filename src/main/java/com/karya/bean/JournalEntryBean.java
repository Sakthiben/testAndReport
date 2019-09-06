package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class JournalEntryBean {
	
	private int jeId;
	
	@NotNull
	 @NotEmpty(message = "Please enter title")
	private String title;
	
	@NotNull
	 @NotEmpty(message = "Please select type")
	private String status;
	
	@NotNull
	 @NotEmpty(message = "Please enter reference number")
	private String referenceNumber;
	
	@NotNull
	 @NotEmpty(message = "Please enter series")
	private String jeSeries;
	
	@NotNull
	 @NotEmpty(message = "Please mention posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please mention reference date")
	private String referenceDate;
	
	@NotNull
	 @NotEmpty(message = "Please mention  account name")
	private String accountName;
	
	@NotNull
	 @NotEmpty(message = "Please mention  party name")
	private String partyName;
	
	@NotNull
	 @NotEmpty(message = "Please enter credit amount")
	private String credit;
	
	@NotNull
	 @NotEmpty(message = "Please enter debit amount")
	private String debit;
	
	@NotNull
	 @NotEmpty(message = "Please select  document status")
	private String docStatus;
	public int getJeId() {
		return jeId;
	}
	public void setJeId(int jeId) {
		this.jeId = jeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getJeSeries() {
		return jeSeries;
	}
	public void setJeSeries(String jeSeries) {
		this.jeSeries = jeSeries;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	

}
