package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PaymentEntryBean {
	
	private int payentId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the Series")
	private String entrySeries;
	
	@NotNull
	 @NotEmpty(message = "Please enter the posting date")
	private String postingDate;
	
	@NotNull
	 @NotEmpty(message = "Please select payment type")
	private String paymentType;
	
	@NotNull
	 @NotEmpty(message = "Please select payment mode")
	private String paymentMode;
	
	@NotNull
	 @NotEmpty(message = "Please select party type")
	private String partyType;
	
	@NotNull
	 @NotEmpty(message = "Please select party name")
	private String partyName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the account payee")
	private String accpaidTo;
	public int getPayentId() {
		return payentId;
	}
	public void setPayentId(int payentId) {
		this.payentId = payentId;
	}
	public String getEntrySeries() {
		return entrySeries;
	}
	public void setEntrySeries(String entrySeries) {
		this.entrySeries = entrySeries;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getAccpaidTo() {
		return accpaidTo;
	}
	public void setAccpaidTo(String accpaidTo) {
		this.accpaidTo = accpaidTo;
	}

}
