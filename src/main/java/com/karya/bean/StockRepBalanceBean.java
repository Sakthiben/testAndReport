package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockRepBalanceBean {
	
	private int stbalId;
	
	@NotNull
	@NotEmpty(message = "Please enter the item")
	private String itemCode;
	
	@NotNull
	@NotEmpty(message = "Please enter the item Group")
	private String itemGroup;
	
	private String brand;
	
	@NotNull
	@NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	@NotEmpty(message = "Please enter the ware House")
	private String wareHouse;
	
	@NotNull
	@NotEmpty(message = "Please mention the UOM")
	private String stkUOM;
	
	@NotNull
	@NotEmpty(message = "Please enter the opening quantity")
	private String openingQty;
	
	@NotNull
	@NotEmpty(message = "Please enter the opening value")
	private String openingValue;
	
	@NotNull
	@NotEmpty(message = "Please enter the in quantity")
	private String inQty;
	
	@NotNull
	@NotEmpty(message = "Please enter the out quantity")
	private String outQty;
	
	@NotNull
	@NotEmpty(message = "Please enter the out value")
	private String outValue;
	
	@NotNull
	@NotEmpty(message = "Please enter the balance quantity")
	private String balanceQty;
	
	@NotNull
	@NotEmpty(message = "Please enter the balance value")
	private String balanceValue;
	
	@NotNull
	@NotEmpty(message = "Please enter the valuation rate")
	private String valuationRate;
	
	@NotNull
	@NotEmpty(message = "Please mention company")
	private String company;
	
	
	public int getStbalId() {
		return stbalId;
	}
	public void setStbalId(int stbalId) {
		this.stbalId = stbalId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}
	public String getStkUOM() {
		return stkUOM;
	}
	public void setStkUOM(String stkUOM) {
		this.stkUOM = stkUOM;
	}
	public String getOpeningQty() {
		return openingQty;
	}
	public void setOpeningQty(String openingQty) {
		this.openingQty = openingQty;
	}
	public String getOpeningValue() {
		return openingValue;
	}
	public void setOpeningValue(String openingValue) {
		this.openingValue = openingValue;
	}
	public String getInQty() {
		return inQty;
	}
	public void setInQty(String inQty) {
		this.inQty = inQty;
	}
	public String getOutQty() {
		return outQty;
	}
	public void setOutQty(String outQty) {
		this.outQty = outQty;
	}
	public String getOutValue() {
		return outValue;
	}
	public void setOutValue(String outValue) {
		this.outValue = outValue;
	}
	public String getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(String balanceQty) {
		this.balanceQty = balanceQty;
	}
	public String getBalanceValue() {
		return balanceValue;
	}
	public void setBalanceValue(String balanceValue) {
		this.balanceValue = balanceValue;
	}
	public String getValuationRate() {
		return valuationRate;
	}
	public void setValuationRate(String valuationRate) {
		this.valuationRate = valuationRate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
