package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchaseregister001mb")
public class PurchaseRegister001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "regId")
	private int regId;
	
	@Column(name="invoice")
	private String invoice;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="supType")
	private String supType;
	
	@Column(name="accountType")
	private String accountType;
	
		
	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="projectname")
	private String projectname;
	
	
	@Column(name="billNo")
	private String billNo;
	
	@Column(name="billDate")
	private String billDate;
	
	@Column(name="remarks")
	private String remarks;
	
		
	@Column(name="poSeries")
	private String poSeries;
	
	@Column(name="purecpt")
	private String purecpt;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="furnituresCount")
	private String furnituresCount;
	
		
	@Column(name="softwaresCount")
	private String softwaresCount;
	
	@Column(name="stkrecBalance")
	private String stkrecBalance;
	
	@Column(name="netTotal")
	private String netTotal;
	
	@Column(name="totalTax")
	private String totalTax;
	
	@Column(name="grandTotal")
	private String grandTotal;
	
	@Column(name="roundTotal")
	private String roundTotal;
	
	@Column(name="outstandAmt")
	private String outstandAmt;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupType() {
		return supType;
	}

	public void setSupType(String supType) {
		this.supType = supType;
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

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPoSeries() {
		return poSeries;
	}

	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}

	public String getPurecpt() {
		return purecpt;
	}

	public void setPurecpt(String purecpt) {
		this.purecpt = purecpt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFurnituresCount() {
		return furnituresCount;
	}

	public void setFurnituresCount(String furnituresCount) {
		this.furnituresCount = furnituresCount;
	}

	public String getSoftwaresCount() {
		return softwaresCount;
	}

	public void setSoftwaresCount(String softwaresCount) {
		this.softwaresCount = softwaresCount;
	}

	public String getStkrecBalance() {
		return stkrecBalance;
	}

	public void setStkrecBalance(String stkrecBalance) {
		this.stkrecBalance = stkrecBalance;
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

	public String getRoundTotal() {
		return roundTotal;
	}

	public void setRoundTotal(String roundTotal) {
		this.roundTotal = roundTotal;
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
