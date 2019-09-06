package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderItemsDeliveredBean {
	
	private int orditemsId;
	
	@NotNull
	 @NotEmpty(message = "Please enter sales order")
	private String sorderName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the customer name")
	private String customername;
	
	@NotNull
	 @NotEmpty(message = "Please enter the date")
	private String date;
	@NotNull
	 @NotEmpty(message = "Please enter the project name")
	private String projectName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity")
	private String quantity;
	
	@NotNull
	 @NotEmpty(message = "Please enter the deliver quantity")
	private String deliverQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the quantity to deliver")
	private String qtytoDeliver;
	
	@NotNull
	 @NotEmpty(message = "Please enter the rate")
	private String rate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the amount")
	private String amount;
	
	@NotNull
	 @NotEmpty(message = "Please enter the amount to deliver")
	private String amttoDeliver;
	
	@NotNull
	 @NotEmpty(message = "Please enter the available quantity")
	private String availableQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the projected quantity")
	private String projectedQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the expected quantity")
	private String expectedQty;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item group")
	private String itemGroup;
	
	@NotNull
	 @NotEmpty(message = "Please enter the warehouse")
	private String warehouseName;
	public int getOrditemsId() {
		return orditemsId;
	}
	public void setOrditemsId(int orditemsId) {
		this.orditemsId = orditemsId;
	}
	public String getSorderName() {
		return sorderName;
	}
	public void setSorderName(String sorderName) {
		this.sorderName = sorderName;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getDeliverQty() {
		return deliverQty;
	}
	public void setDeliverQty(String deliverQty) {
		this.deliverQty = deliverQty;
	}
	public String getQtytoDeliver() {
		return qtytoDeliver;
	}
	public void setQtytoDeliver(String qtytoDeliver) {
		this.qtytoDeliver = qtytoDeliver;
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
	public String getAmttoDeliver() {
		return amttoDeliver;
	}
	public void setAmttoDeliver(String amttoDeliver) {
		this.amttoDeliver = amttoDeliver;
	}
	public String getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}
	public String getProjectedQty() {
		return projectedQty;
	}
	public void setProjectedQty(String projectedQty) {
		this.projectedQty = projectedQty;
	}
	public String getExpectedQty() {
		return expectedQty;
	}
	public void setExpectedQty(String expectedQty) {
		this.expectedQty = expectedQty;
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
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	
	

}
