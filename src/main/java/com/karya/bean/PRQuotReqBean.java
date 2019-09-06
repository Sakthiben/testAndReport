package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PRQuotReqBean {
	private int prqId;
	@NotNull
	@NotEmpty(message = "Please enter the Series")
	private String rqSeries;
	@NotNull
	@NotEmpty(message = "Please select date")
	private String date;
	@NotNull
	@NotEmpty(message = "Please enter the Supplier Name")
	private String supplier;
	@NotNull
	@NotEmpty(message = "Please specify mail")
	private String emailId;
	@NotNull
	@NotEmpty(message = "Please enter the contact")
	private String contact;
	@NotNull
	@NotEmpty(message = "Please enter the item")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please select the date")
	private String requiredDate;
	@NotNull
	@NotEmpty(message = "Please enter the quantity")
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter the wareHouse")
	private String warehouse;
	public int getPrqId() {
		return prqId;
	}
	public void setPrqId(int prqId) {
		this.prqId = prqId;
	}
	public String getRqSeries() {
		return rqSeries;
	}
	public void setRqSeries(String rqSeries) {
		this.rqSeries = rqSeries;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	

}
