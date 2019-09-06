package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PRPurOrdBean {
	
	private int proId;
	@NotNull
	@NotEmpty(message = "Please enter the Series")
	private String poSeries;
	@NotNull
	@NotEmpty(message = "Please select date")
	private String date;
	@NotNull
	@NotEmpty(message = "Please select supplier name")
	private String supplier;
	@NotNull
	@NotEmpty(message = "Please select Raw Material required or not")
	private String supplyrawmat;
	@NotNull
	@NotEmpty(message = "Please select item")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the quantity")
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter the rate")
	private String rate;
	@NotNull
	@NotEmpty(message = "Please enter the amount")
	private String amount;
	@NotNull
	@NotEmpty(message = "Please enter the Type")
	private String prtype;
	@NotNull
	@NotEmpty(message = "Please mention accountHead")
	private String accountHead;
	@NotNull
	@NotEmpty(message = "Please enter the Quoted Rate")
	private String quotrate;
	@NotNull
	@NotEmpty(message = "Please specify TaxesandCharges")
	private String taxandChg;
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getPoSeries() {
		return poSeries;
	}
	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplyrawmat() {
		return supplyrawmat;
	}
	public void setSupplyrawmat(String supplyrawmat) {
		this.supplyrawmat = supplyrawmat;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrtype() {
		return prtype;
	}
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	public String getAccountHead() {
		return accountHead;
	}
	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}
	public String getQuotrate() {
		return quotrate;
	}
	public void setQuotrate(String quotrate) {
		this.quotrate = quotrate;
	}
	public String getTaxandChg() {
		return taxandChg;
	}
	public void setTaxandChg(String taxandChg) {
		this.taxandChg = taxandChg;
	}
	

}
