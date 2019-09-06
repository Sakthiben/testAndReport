package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="salesRegister001mb")
public class SalesRegister001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "regId")
	private int regId;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="customername")
	private String customername;
	
	@Column(name="customergroup")
	private String customergroup;
	
	@Column(name="terName")
	private String terName;
	
	@Column(name="accountType")
	private String accountType;
	
		
	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="projectname")
	private String projectname;
	
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="salesCode")
	private String salesCode;
	
	@Column(name="delNote")
	private String delNote;
	
		
	@Column(name="currency")
	private String currency;
	
	@Column(name="gainloss")
	private String gainloss;
	
	@Column(name="saleswpl")
	private String saleswpl;
	
	@Column(name="netTotal")
	private String netTotal;
	
		
	@Column(name="totalTax")
	private String totalTax;
	
	@Column(name="grandTotal")
	private String grandTotal;
	
	@Column(name="roundedTotal")
	private String roundedTotal;
	
	@Column(name="outstandAmt")
	private String outstandAmt;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomergroup() {
		return customergroup;
	}

	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}

	public String getTerName() {
		return terName;
	}

	public void setTerName(String terName) {
		this.terName = terName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public String getDelNote() {
		return delNote;
	}

	public void setDelNote(String delNote) {
		this.delNote = delNote;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getGainloss() {
		return gainloss;
	}

	public void setGainloss(String gainloss) {
		this.gainloss = gainloss;
	}

	public String getSaleswpl() {
		return saleswpl;
	}

	public void setSaleswpl(String saleswpl) {
		this.saleswpl = saleswpl;
	}

	public String getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(String netTotal) {
		this.netTotal = netTotal;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getRoundedTotal() {
		return roundedTotal;
	}

	public void setRoundedTotal(String roundedTotal) {
		this.roundedTotal = roundedTotal;
	}
	public String getOutstandAmt() {
		return outstandAmt;
	}

	public void setOutstandAmt(String outstandAmt) {
		this.outstandAmt = outstandAmt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
