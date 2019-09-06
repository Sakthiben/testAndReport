package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;
public class PuItemHistoryBean {
	private int histId;
	@NotNull
	@NotEmpty(message = "Please select the itemCode")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please select the itemCode")
	private String itemGroup;
	@NotNull
	@NotEmpty(message = "Please enter description")
	private String description;
	@NotNull
	@NotEmpty(message = "Please enter quantity")
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter uom")
	private String uom;
	@NotNull
	@NotEmpty(message = "Please enter date")
	private String date;
	@NotNull
	@NotEmpty(message = "Please enter amount")
	private String amount;
	@NotNull
	@NotEmpty(message = "Please select the poSeries")
	private String poSeries;
	@NotNull
	@NotEmpty(message = "Please enter transDate")
	private String transDate;
	@NotNull
	@NotEmpty(message = "Please select the supplier")
	private String supplier;
	@NotNull
	@NotEmpty(message = "Please enter receivedQty")
	private String receivedQty;
	@NotNull
	@NotEmpty(message = "Please enter company")
	private String company;
	public int getHistId() {
		return histId;
	}
	public void setHistId(int histId) {
		this.histId = histId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPoSeries() {
		return poSeries;
	}
	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	

}
