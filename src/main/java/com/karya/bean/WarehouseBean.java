package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class WarehouseBean {
	
	private int whId;
	
	@NotNull
	@NotEmpty(message = "Please enter the warehouse name")
	private String warehouseName;
	
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	
	@NotNull
	@NotEmpty(message = "Please specify the active or inactive mode")
	private String isActive;
	
	@NotNull
	@NotEmpty(message = "Please enter warehouse code")
	private String warehouseCode;
	public int getWhId() {
		return whId;
	}
	public void setWhId(int whId) {
		this.whId = whId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
	

}
