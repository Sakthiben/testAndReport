package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MatchPaymentsBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Company Name.")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please Enter Party Type")
	private String partytype;
	
	@NotNull
	@NotEmpty(message = "Please Enter Party")
	private String party;
	
	@NotNull
	@NotEmpty(message = "Please Enter Receivable or Payable Account ")
	private String receivableorpayableaccount;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String fromdate;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String todate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Bank or Cash Account")
	private String bankorcashaccount;
	
	@Min(value=1)
	@NotNull(message= "Please Enter Minimum Invoice Amount")
	private int minimuminvoiceamount;
	
	@Min(value=1)
	@NotNull(message= "Please Enter Maximum Invoice Amount")
	private int maximuminvoiceamount;
	
	@NotNull
	@NotEmpty(message = "Please Enter reference name")
	private String refName;
	
	@NotNull
	@NotEmpty(message = "Please Enter invoice number")
	private String invoiceNumber;
	
	@NotNull
	@NotEmpty(message = "Please Enter amount")
	private String amount;
	
	@NotNull
	@NotEmpty(message = "Please Enter allocated amount")
	private String allocatedamount;
	
	
	
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAllocatedamount() {
		return allocatedamount;
	}
	public void setAllocatedamount(String allocatedamount) {
		this.allocatedamount = allocatedamount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPartytype() {
		return partytype;
	}
	public void setPartytype(String partytype) {
		this.partytype = partytype;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getReceivableorpayableaccount() {
		return receivableorpayableaccount;
	}
	public void setReceivableorpayableaccount(String receivableorpayableaccount) {
		this.receivableorpayableaccount = receivableorpayableaccount;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getBankorcashaccount() {
		return bankorcashaccount;
	}
	public void setBankorcashaccount(String bankorcashaccount) {
		this.bankorcashaccount = bankorcashaccount;
	}
	public int getMinimuminvoiceamount() {
		return minimuminvoiceamount;
	}
	public void setMinimuminvoiceamount(int minimuminvoiceamount) {
		this.minimuminvoiceamount = minimuminvoiceamount;
	}
	public int getMaximuminvoiceamount() {
		return maximuminvoiceamount;
	}
	public void setMaximuminvoiceamount(int maximuminvoiceamount) {
		this.maximuminvoiceamount = maximuminvoiceamount;
	}
	
}
