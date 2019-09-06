package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="accgenledge001mb")
public class AccGenLedge001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "accglId")
	private int accglId;
	
	@Column(name="company")
	private String company;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="partyType")
	private String partyType;
	
	@Column(name="partyName")
	private String partyName;
	
	@Column(name="grpbyVoucher")
	private boolean grpbyVoucher;
	
	@Column(name="grobyAccount")
	private boolean grobyAccount;
	
	@Column(name="letterHead")
	private String letterHead;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="debit")
	private String debit;
	
	@Column(name="credit")
	private String credit;
	
	@Column(name="voucherType")
	private String voucherType;
	
	@Column(name="voucherCode")
	private String voucherCode;
	
	@Column(name="againstAmt")
	private String againstAmt;
	
	@Column(name="projectname")
	private String projectname;
	
	
	
	
	@Column(name="costCenter")
	private String costCenter;
	
	@Column(name="againvcType")
	private String againvcType;
	
	@Column(name="againvcName")
	private String againvcName;

	public int getAccglId() {
		return accglId;
	}

	public void setAccglId(int accglId) {
		this.accglId = accglId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public boolean isGrpbyVoucher() {
		return grpbyVoucher;
	}

	public void setGrpbyVoucher(boolean grpbyVoucher) {
		this.grpbyVoucher = grpbyVoucher;
	}

	public boolean isGrobyAccount() {
		return grobyAccount;
	}

	public void setGrobyAccount(boolean grobyAccount) {
		this.grobyAccount = grobyAccount;
	}

	public String getLetterHead() {
		return letterHead;
	}

	public void setLetterHead(String letterHead) {
		this.letterHead = letterHead;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getAgainstAmt() {
		return againstAmt;
	}

	public void setAgainstAmt(String againstAmt) {
		this.againstAmt = againstAmt;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getAgainvcType() {
		return againvcType;
	}

	public void setAgainvcType(String againvcType) {
		this.againvcType = againvcType;
	}

	public String getAgainvcName() {
		return againvcName;
	}

	public void setAgainvcName(String againvcName) {
		this.againvcName = againvcName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
