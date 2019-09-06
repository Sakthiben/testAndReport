package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateBankBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Your Account.")
	private String bankaccount;
	
	@NotNull
	@NotEmpty(message = "Please select Date.")
	private String fromdate;
	
	@NotNull
	@NotEmpty(message = "Please select Date.")
	private String todate;
	
	@NotNull
	@NotEmpty(message = "Please select customer.")
	private String customername;
	
	@NotNull
	@NotEmpty(message = "Please enter amount.")
	private String amount;
	
	@NotNull
	@NotEmpty(message = "Please enter cheque number.")
	private String chqNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter clearance date.")
	private String clearanceDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
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
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getChqNumber() {
		return chqNumber;
	}
	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}
	public String getClearanceDate() {
		return clearanceDate;
	}
	public void setClearanceDate(String clearanceDate) {
		this.clearanceDate = clearanceDate;
	}
	
	
	
}
