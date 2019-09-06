package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StkRepProjectedBean {
	
	private int stprojId;
	@NotNull
	@NotEmpty(message = "Please enter the item")
	
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the description")
	
	private String description;
	@NotNull
	@NotEmpty(message = "Please enter the item group")
	
	private String itemGroup;
	
	private String brand;
	@NotNull
	@NotEmpty(message = "Please enter the wareHouse")
	
	private String wareHouse;
	@NotNull
	@NotEmpty(message = "Please mention UOM")
	
	private String UOM;
	@NotNull
	@NotEmpty(message = "Please enter the actual quantity")
	
	private String actualQty;
	@NotNull
	@NotEmpty(message = "Please enter the planned quantity")
	
	private String plannedQty;
	@NotNull
	@NotEmpty(message = "Please enter the requested quantity")
	

	private String requestedQty;
	@NotNull
	@NotEmpty(message = "Please enter the ordered quantity")
	

	private String orderedQty;
	@NotNull
	@NotEmpty(message = "Please enter the reserved quantity")
	
	private String reservedQty;
	@NotNull
	@NotEmpty(message = "Please enter the reorder value")
	

	private String reorderValue;
	@NotNull
	@NotEmpty(message = "Please enter the reorder quantity")
	

	private String reorderQty;
	@NotNull
	@NotEmpty(message = "Please enter the shortage quantity")
	
	
	private String shortageQty;

	public int getStprojId() {
		return stprojId;
	}

	public void setStprojId(int stprojId) {
		this.stprojId = stprojId;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getActualQty() {
		return actualQty;
	}

	public void setActualQty(String actualQty) {
		this.actualQty = actualQty;
	}

	public String getPlannedQty() {
		return plannedQty;
	}

	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}

	public String getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(String requestedQty) {
		this.requestedQty = requestedQty;
	}

	public String getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}

	public String getReservedQty() {
		return reservedQty;
	}

	public void setReservedQty(String reservedQty) {
		this.reservedQty = reservedQty;
	}

	public String getReorderValue() {
		return reorderValue;
	}

	public void setReorderValue(String reorderValue) {
		this.reorderValue = reorderValue;
	}

	public String getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(String reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getShortageQty() {
		return shortageQty;
	}

	public void setShortageQty(String shortageQty) {
		this.shortageQty = shortageQty;
	}
	


}
