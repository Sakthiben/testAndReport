package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockEntryBean {
	
	 private int stockid;
	 //@NotNull
	//@NotEmpty(message = "Please enter the material request") 
	 private String materialrequest;
	 private String date;
	 private int itemid;
	 //@NotNull
		//@NotEmpty(message = "Please enter quantity") 
	 private  int   Quantity; 
	// @NotNull
	//	@NotEmpty(message = "Please enter transfered quantity") 
     private double TransferedQty ;
	// @NotNull
		//@NotEmpty(message = "Please enter qtytotransfer") 
     private double Qtytotransfer;
     
	 //@NotNull
		//@NotEmpty(message = "Please enter description") 
	 private String description;
     
	 @NotNull
	 @NotEmpty(message = "Please enter company") 
     private String Company;
     
	public int getItemid() {
		return itemid;
	}
	
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public String getMaterialrequest() {
		return materialrequest;
	}
	public void setMaterialrequest(String materialrequest) {
		this.materialrequest = materialrequest;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public double getTransferedQty() {
		return TransferedQty;
	}
	public void setTransferedQty(double transferedQty) {
		TransferedQty = transferedQty;
	}
	public double getQtytotransfer() {
		return Qtytotransfer;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public void setQtytotransfer(double qtytotransfer) {
		Qtytotransfer = qtytotransfer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	
} 
	 