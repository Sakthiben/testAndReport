package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StkRepLedgerBean {
	private int stledId;
	@NotNull
	@NotEmpty(message = "Please specify date")
	private String date;
	@NotNull
	@NotEmpty(message = "Please enter the item")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the itemGroup")
	
	private String itemGroup;
	
	private String brand;
	@NotNull
	@NotEmpty(message = "Please enter the description")
	
	private String description;
	@NotNull
	@NotEmpty(message = "Please enter the wareHouse")
	
	private String wareHouse;
	@NotNull
	@NotEmpty(message = "Please enter the UOM")
	
	private String stkUOM;
	@NotNull
	@NotEmpty(message = "Please enter the quantity")
	
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter the balance quantity")
	
	private String balanceQty;
	@NotNull
	@NotEmpty(message = "Please enter the incoming Rate")
	
	private String incomingRate;
	@NotNull
	@NotEmpty(message = "Please enter the valuation Rate")
	
	private String valuationRate;
	@NotNull
	@NotEmpty(message = "Please enter the balance value")
	
	private String balanceValue;
	@NotNull
	@NotEmpty(message = "Please select the voucehr type")
	
	private String voucherType;
	@NotNull
	@NotEmpty(message = "Please enter the voucher code")
	
	private String voucherCode;
	private String batch;
	@NotNull
	@NotEmpty(message = "Please enter the serial No")
	
	private String serialNo;
	@NotNull
	@NotEmpty(message = "Please enter the company")
	
	private String company;
	public int getStledId() {
		return stledId;
	}
	public void setStledId(int stledId) {
		this.stledId = stledId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(String balanceQty) {
		this.balanceQty = balanceQty;
	}
	public String getIncomingRate() {
		return incomingRate;
	}
	public void setIncomingRate(String incomingRate) {
		this.incomingRate = incomingRate;
	}
	public String getValuationRate() {
		return valuationRate;
	}
	public void setValuationRate(String valuationRate) {
		this.valuationRate = valuationRate;
	}
	public String getBalanceValue() {
		return balanceValue;
	}
	public void setBalanceValue(String balanceValue) {
		this.balanceValue = balanceValue;
	}
	public String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
