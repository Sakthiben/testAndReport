package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RequestItemBuyBean {
	private int riId;
	@NotNull
	@NotEmpty(message = "Please select item")
	
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter WareHouse")
	
	private String warehouse;
	@NotNull
	@NotEmpty(message = "Please enter the actual data")
	
	private String actual;
	@NotNull
	@NotEmpty(message = "Please enter the requested data")
	
	private String requested;
	@NotNull
	@NotEmpty(message = "Please enter the reserved data")
	
	private String reserved;
	@NotNull
	@NotEmpty(message = "Please enter the ordered data")
	
	private String ordered;
	@NotNull
	@NotEmpty(message = "Please enter the projected data")
	
	private String projected;
	public int getRiId() {
		return riId;
	}
	public void setRiId(int riId) {
		this.riId = riId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getRequested() {
		return requested;
	}
	public void setRequested(String requested) {
		this.requested = requested;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public String getOrdered() {
		return ordered;
	}
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}
	public String getProjected() {
		return projected;
	}
	public void setProjected(String projected) {
		this.projected = projected;
	}
	
	

}
