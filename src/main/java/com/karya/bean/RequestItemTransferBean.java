package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RequestItemTransferBean {
	private int ittransId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the material request")
	private String mrSeries;
	
	@NotNull
	 @NotEmpty(message = "Please enter the date")
	private String date;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity")
	private String quantity;
	
	@NotNull
	 @NotEmpty(message = "Please enter the transfer quantity")
	private String transferQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity to transfer")
	private String qtytoTransfer;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item code")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	 @NotEmpty(message = "Please enter the company")
	private String company;
	public int getIttransId() {
		return ittransId;
	}
	public void setIttransId(int ittransId) {
		this.ittransId = ittransId;
	}
	public String getMrSeries() {
		return mrSeries;
	}
	public void setMrSeries(String mrSeries) {
		this.mrSeries = mrSeries;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTransferQty() {
		return transferQty;
	}
	public void setTransferQty(String transferQty) {
		this.transferQty = transferQty;
	}
	public String getQtytoTransfer() {
		return qtytoTransfer;
	}
	public void setQtytoTransfer(String qtytoTransfer) {
		this.qtytoTransfer = qtytoTransfer;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
