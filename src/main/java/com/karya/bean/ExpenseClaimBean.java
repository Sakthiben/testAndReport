package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ExpenseClaimBean {
	private int expclmId;
	 @NotNull
	 @NotEmpty(message = "Please select the status")
	private String status;
	 @NotNull
	 @NotEmpty(message = "Please enter Total Claim Amount")
	private String totalclmAmt;
	 @NotNull
	 @NotEmpty(message = "Please enter Expense Code")
	private String expCode;
	 @NotNull
	 @NotEmpty(message = "Please select the expense type")
	private String expType;
	public int getExpclmId() {
		return expclmId;
	}
	public void setExpclmId(int expclmId) {
		this.expclmId = expclmId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalclmAmt() {
		return totalclmAmt;
	}
	public void setTotalclmAmt(String totalclmAmt) {
		this.totalclmAmt = totalclmAmt;
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public String getExpType() {
		return expType;
	}
	public void setExpType(String expType) {
		this.expType = expType;
	}
	
	

}
