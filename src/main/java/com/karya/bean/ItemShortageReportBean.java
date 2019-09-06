package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemShortageReportBean {
	
	private int shrepid;
	
	@NotNull
	 @NotEmpty(message = "Please enter the warehouse name")
	private String warehouseName;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item")
	private String itemCode;
	
	
	private String actualQty;
	
	
	private String orderedQty;
	private String plannedQty;
	private String reservedQty;
	private String projectedQty;
	public int getShrepid() {
		return shrepid;
	}
	public void setShrepid(int shrepid) {
		this.shrepid = shrepid;
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
	public String getActualQty() {
		return actualQty;
	}
	public void setActualQty(String actualQty) {
		this.actualQty = actualQty;
	}
	public String getOrderedQty() {
		return orderedQty;
	}
	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}
	public String getPlannedQty() {
		return plannedQty;
	}
	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}
	public String getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(String reservedQty) {
		this.reservedQty = reservedQty;
	}
	public String getProjectedQty() {
		return projectedQty;
	}
	public void setProjectedQty(String projectedQty) {
		this.projectedQty = projectedQty;
	}
	

}
