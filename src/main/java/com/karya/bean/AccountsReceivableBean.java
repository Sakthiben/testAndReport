package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountsReceivableBean {
	
	private int id;
	@NotNull
	 @NotEmpty(message = "Please enter posting date")
	private String postingdate;
	@NotNull
	 @NotEmpty(message = "Please select customer name")
	private String customer;
	@NotNull
	@NotEmpty(message = "Please enter material request")
	private String vouchertype;
	@NotNull
	@NotEmpty(message = "Please enter voucher number")
	private String voucherno;
	@NotNull
	@NotEmpty(message = "Please enter due date")
	private String duedate;
	@NotNull
	@Min(1)
	private int invoicedamount;
	@NotNull
	@Min(1)
	private int paidamount;
	@NotNull
	@Min(1)
	private int outstandingamount;
	@NotNull
	@Min(1)
	private int age;
	@NotNull
	@Min(1)
	private int uptothirty;
	@NotNull
	@Min(1)
	private int uptosixty;
	@NotNull
	@Min(1)
	private int uptoninety;
	@NotNull
	@Min(1)
	private int ninetyabove;
	@NotNull
	@NotEmpty(message = "Please enter currency")
	private String currency;
	@NotNull
	@NotEmpty(message = "Please enter territory")
	private String territory;
	@NotNull
	@NotEmpty(message = "Please enter remarks")
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getVouchertype() {
		return vouchertype;
	}
	public void setVouchertype(String vouchertype) {
		this.vouchertype = vouchertype;
	}
	public String getVoucherno() {
		return voucherno;
	}
	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public int getInvoicedamount() {
		return invoicedamount;
	}
	public void setInvoicedamount(int invoicedamount) {
		this.invoicedamount = invoicedamount;
	}
	public int getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(int paidamount) {
		this.paidamount = paidamount;
	}
	public int getOutstandingamount() {
		return outstandingamount;
	}
	public void setOutstandingamount(int outstandingamount) {
		this.outstandingamount = outstandingamount;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getUptothirty() {
		return uptothirty;
	}
	public void setUptothirty(int uptothirty) {
		this.uptothirty = uptothirty;
	}
	public int getUptosixty() {
		return uptosixty;
	}
	public void setUptosixty(int uptosixty) {
		this.uptosixty = uptosixty;
	}
	public int getUptoninety() {
		return uptoninety;
	}
	public void setUptoninety(int uptoninety) {
		this.uptoninety = uptoninety;
	}
	public int getNinetyabove() {
		return ninetyabove;
	}
	public void setNinetyabove(int ninetyabove) {
		this.ninetyabove = ninetyabove;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
