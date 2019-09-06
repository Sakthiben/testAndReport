package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PRMatReqBean {
	private int pmrId;
	@NotNull
	@NotEmpty(message = "Please enter the Type")
	private String mrType;
	@NotNull
	@NotEmpty(message = "Please enter the Series")
	private String mrSeries;
	@NotNull
	@NotEmpty(message = "Please enter the Item")
	
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the Quantity")
	
	private String quantity;
	@NotNull
	@NotEmpty(message = "Please enter the WareHouse")
	
	private String forWarehouse;
	@NotNull
	@NotEmpty(message = "Please select the respective date")
	
	private String requiredDate;
	public int getPmrId() {
		return pmrId;
	}
	public void setPmrId(int pmrId) {
		this.pmrId = pmrId;
	}
	public String getMrType() {
		return mrType;
	}
	public void setMrType(String mrType) {
		this.mrType = mrType;
	}
	public String getMrSeries() {
		return mrSeries;
	}
	public void setMrSeries(String mrSeries) {
		this.mrSeries = mrSeries;
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
	public String getForWarehouse() {
		return forWarehouse;
	}
	public void setForWarehouse(String forWarehouse) {
		this.forWarehouse = forWarehouse;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	

}
