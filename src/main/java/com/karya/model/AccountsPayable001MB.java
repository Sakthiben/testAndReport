package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountspayable001mb")
public class AccountsPayable001MB {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="postingdate")
	private String postingdate;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="suppliertype")
	private String suppliertype;
	
	@Column(name="vouchertype")
	private String vouchertype;
	
	@Column(name="vouchernumber")
	private String vouchernumber;
	
	@Column(name="duedate")
	private String duedate;
	
	@Column(name="billno")
	private String billno;
	
	@Column(name="billdate")
	private String billdate;
	
	@Column(name="invoicedamount")
	private int invoicedamount;
	
	@Column(name="paidamount")
	private int paidamount;
	
	@Column(name="outstandingamount")
	private int outstandingamount;

	@Column(name="age")
	private int age;
	
	@Column(name="uptothirty")
	private int uptothirty;
	
	@Column(name="uptosixty")
	private int uptosixty;
	
	@Column(name="uptoninety")
	private int uptoninety;
	
	@Column(name="ninetyabove")
	private int ninetyabove;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="remarks")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
