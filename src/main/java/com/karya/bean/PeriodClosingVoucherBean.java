package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PeriodClosingVoucherBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String transactiondate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Closing Account Head")
	private String closingaccounthead;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String postingdate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Year")
	private String closingfiscalyear;
	
	@NotNull
	@NotEmpty(message = "Please Enter Company")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please Enter Remarks")
	private String remarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getClosingaccounthead() {
		return closingaccounthead;
	}
	public void setClosingaccounthead(String closingaccounthead) {
		this.closingaccounthead = closingaccounthead;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	public String getClosingfiscalyear() {
		return closingfiscalyear;
	}
	public void setClosingfiscalyear(String closingfiscalyear) {
		this.closingfiscalyear = closingfiscalyear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
