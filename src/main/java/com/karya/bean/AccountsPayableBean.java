package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountsPayableBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String postingdate;

    @NotNull
    @NotEmpty(message = "Please select Supplier")
	private String supplier;
	
	@NotNull
	@NotEmpty(message = "Please Select SupplierType")
	private String suppliertype;
	
	@NotNull
	@NotEmpty(message = "Please Enter Voucher Type")
	private String vouchertype;
	
	@NotNull
	@NotEmpty(message = "Please Enter Voucher Number")
	private String vouchernumber;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String duedate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Bill Number")
	private String billno;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String billdate;
	
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
	@NotEmpty(message = "Please Enter Currency")
	private String currency;
	
	@NotNull
	@NotEmpty(message = "Please Enter Remarks")
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSuppliertype() {
		return suppliertype;
	}
	public void setSuppliertype(String suppliertype) {
		this.suppliertype = suppliertype;
	}
	public String getVouchertype() {
		return vouchertype;
	}
	public void setVouchertype(String vouchertype) {
		this.vouchertype = vouchertype;
	}
	public String getVouchernumber() {
		return vouchernumber;
	}
	public void setVouchernumber(String vouchernumber) {
		this.vouchernumber = vouchernumber;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
