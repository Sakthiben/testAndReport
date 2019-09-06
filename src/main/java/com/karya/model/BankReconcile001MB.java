package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankreconcile001mb")
public class BankReconcile001MB implements Serializable{

private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bankrecId")
	private int bankrecId;
	
	@Column(name="bankAccount")
	private String bankAccount;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="entrySeries")
	private String entrySeries;
	
	@Column(name="debit")
	private String debit;
	
	@Column(name="credit")
	private String credit;
	
	@Column(name="againstAccount")
	private String againstAccount;
	
	@Column(name="referenceName")
	private String referenceName;
	
	@Column(name="referenceDate")
	private String referenceDate;
	
	@Column(name="clearanceDate")
	private String clearanceDate;
	
	@Column(name="currency")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
