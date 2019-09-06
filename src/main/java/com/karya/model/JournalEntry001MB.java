package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jounalentry001mb")
public class JournalEntry001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "jeId")
	private int jeId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="status")
	private String status;
	
	@Column(name="referenceNumber")
	private String referenceNumber;
	
	@Column(name="jeSeries")
	private String jeSeries;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="referenceDate")
	private String referenceDate;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="partyName")
	private String partyName;
	
	@Column(name="credit")
	private String credit;
	
	@Column(name="debit")
	private String debit;
	
	@Column(name="docStatus")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
