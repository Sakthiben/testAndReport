package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ReqItemOrdBuyBean {
	
	private int mrsId;
	@NotNull
	@NotEmpty(message = "Please enter the Series")
	
	private String mrSeries;
	@NotNull
	@NotEmpty(message = "Please select date")
	
	private String date;
	@NotNull
	@NotEmpty(message = "Please select item")
	
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the quantity")
	
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter the description")
	
	private String description;
	@NotNull
	@NotEmpty(message = "Please enter the company")
	
	private String company;
	@NotNull
	@NotEmpty(message = "Please enter the Ordered quantity")
	
	private String orderedqty;
	@NotNull
	@NotEmpty(message = "Please enter the Quantity to be ordered")
	
	private String qtytoorder;
	public int getMrsId() {
		return mrsId;
	}
	public void setMrsId(int mrsId) {
		this.mrsId = mrsId;
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
	public String getOrderedqty() {
		return orderedqty;
	}
	public void setOrderedqty(String orderedqty) {
		this.orderedqty = orderedqty;
	}
	public String getQtytoorder() {
		return qtytoorder;
	}
	public void setQtytoorder(String qtytoorder) {
		this.qtytoorder = qtytoorder;
	}
	

}
