package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PRSuQuotReqBean {
	
	private int prsrId;
	@NotNull
	@NotEmpty(message = "Please enter the Series")
	private String suSeries;
	@NotNull
	@NotEmpty(message = "Please select date")
	private String date;
	@NotNull
	@NotEmpty(message = "Please enter the suppplier name")
	private String supplier;
	@NotNull
	@NotEmpty(message = "Please select the item")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please mention the quantity")
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please mention the UOM")
	private String stockUOM;
	@NotNull
	@NotEmpty(message = "Please mention the rate")
	private String rate;
	@NotNull
	@NotEmpty(message = "Please enter the TaxesandCharges")
	private String taxandChg;
	@NotNull
	@NotEmpty(message = "Please enter the accountHead")
	private String accountHead;
	@NotNull
	@NotEmpty(message = "Please enter the Quoted Rate")
	private String squotrate;
	@NotNull
	@NotEmpty(message = "Please enter the Type")
	private String sutype;
	public int getPrsrId() {
		return prsrId;
	}
	public void setPrsrId(int prsrId) {
		this.prsrId = prsrId;
	}
	public String getSuSeries() {
		return suSeries;
	}
	public void setSuSeries(String suSeries) {
		this.suSeries = suSeries;
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
	public String getStockUOM() {
		return stockUOM;
	}
	public void setStockUOM(String stockUOM) {
		this.stockUOM = stockUOM;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getTaxandChg() {
		return taxandChg;
	}
	public void setTaxandChg(String taxandChg) {
		this.taxandChg = taxandChg;
	}
	public String getAccountHead() {
		return accountHead;
	}
	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}
	public String getSquotrate() {
		return squotrate;
	}
	public void setSquotrate(String squotrate) {
		this.squotrate = squotrate;
	}
	public String getSutype() {
		return sutype;
	}
	public void setSutype(String sutype) {
		this.sutype = sutype;
	}
	
	
	

}
