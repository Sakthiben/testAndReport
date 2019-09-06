package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankclearance001mb")
public class BankClearance001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bankclrId")
	private int bankclrId;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="bankAccount")
	private String bankAccount;
	
	@Column(name="payDocument")
	private String payDocument;
	
	@Column(name="entrySeries")
	private String entrySeries;
	
	@Column(name="chequeref")
	private String chequeref;
	
	@Column(name="clearanceDate")
	private String clearanceDate;
	
	@Column(name="againstAccount")
	private String againstAccount;
	
	@Column(name="amount")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
