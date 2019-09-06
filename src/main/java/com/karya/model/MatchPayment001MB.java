package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matchpayment001mb")
public class MatchPayment001MB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="company")
	private String company;
	
	@Column(name="partytype")
	private String partytype;
	
	@Column(name="party")
	private String party;
	
	@Column(name="receivableorpayableaccount")
	private String receivableorpayableaccount;
	
	@Column(name="fromdate")
	private String fromdate;
	
	@Column(name="todate")
	private String todate;
	
	@Column(name="bankorcashaccount")
	private String bankorcashaccount;
	
	@Column(name="minimuminvoiceamount")
	private int minimuminvoiceamount;
	
	@Column(name="maximuminvoiceamount")
	private int maximuminvoiceamount;
	
	@Column(name="refName")
	private String refName;
	
	@Column(name="invoiceNumber")
	private String invoiceNumber;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="allocatedamount")
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
