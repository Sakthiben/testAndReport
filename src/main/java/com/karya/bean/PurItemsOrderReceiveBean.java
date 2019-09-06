package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PurItemsOrderReceiveBean {
	
	private int poitrecId;
	@NotNull
	 @NotEmpty(message = "Please enter the purchase order")
	private String puOrder;
	
	@NotNull
	 @NotEmpty(message = "Please enter the date")
	private String date;
	
	@NotNull
	 @NotEmpty(message = "Please enter required by date")
	private String reqbyDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the supplier name")
	private String supName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the project name")
	private String projectName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity")
	private String quantity;
	
	@NotNull
	 @NotEmpty(message = "Please enter the received quantity")
	private String receivedQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity to receive")
	private String qtytoReceive;
	
	@NotNull
	 @NotEmpty(message = "Please enter the warehouse name")
	private String warehouseName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the itemcode")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	 @NotEmpty(message = "Please enter the brand name")
	private String brandName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the company")
	private String company;
	public int getPoitrecId() {
		return poitrecId;
	}
	public void setPoitrecId(int poitrecId) {
		this.poitrecId = poitrecId;
	}
	public String getPuOrder() {
		return puOrder;
	}
	public void setPuOrder(String puOrder) {
		this.puOrder = puOrder;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReqbyDate() {
		return reqbyDate;
	}
	public void setReqbyDate(String reqbyDate) {
		this.reqbyDate = reqbyDate;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}
	public String getQtytoReceive() {
		return qtytoReceive;
	}
	public void setQtytoReceive(String qtytoReceive) {
		this.qtytoReceive = qtytoReceive;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
