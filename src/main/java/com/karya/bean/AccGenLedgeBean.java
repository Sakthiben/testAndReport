package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AccGenLedgeBean {
	private int accglId;
	@NotNull
	 @NotEmpty(message = "Please enter comapny")
	private String company;
	@NotNull
	@NotEmpty(message = "Please mention from date")
	private String fromDate;
	@NotNull
	 @NotEmpty(message = "Please mention to date")
	private String toDate;
	@NotNull
	 @NotEmpty(message = "Please select party type")
	private String partyType;
	@NotNull
	@NotEmpty(message = "Please enter party name")
	private String partyName;
	
	private boolean grpbyVoucher;
	
	private boolean grobyAccount;
	@NotNull
	@NotEmpty(message = "Please enter letter head")
	private String letterHead;
	@NotNull
	@NotEmpty(message = "Please mention posting date")
	private String postingDate;
	@NotNull
	@NotEmpty(message = "Please enter account ")
	private String accountName;
	@NotNull
	@NotEmpty(message = "Please specify debit value")
	private String debit;
	@NotNull
	@NotEmpty(message = "Please specify credit value")
	private String credit;
	@NotNull
	@NotEmpty(message = "Please select voucher type")
	private String voucherType;
	@NotNull
	@NotEmpty(message = "Please enter voucher code")
	private String voucherCode;
	@NotNull
	@NotEmpty(message = "Please enter against amount")
	private String againstAmt;
	@NotNull
	@NotEmpty(message = "Please enter project name")
	private String projectname;
	@NotNull
	@NotEmpty(message = "Please specify cost center")
	private String costCenter;
	
	@NotNull
	@NotEmpty(message = "Please enter against voucher type")
	private String againvcType;
	@NotNull
	@NotEmpty(message = "Please enter again voucher name")
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
	
	

}
