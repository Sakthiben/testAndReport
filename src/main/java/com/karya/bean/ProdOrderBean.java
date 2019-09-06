package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProdOrderBean {
	private int prId;
	 @NotNull
	 @NotEmpty(message = "Please enter Items To Manufacture")
	private String itemtoManufacture;
	 @NotNull
	 @NotEmpty(message = "Please select status")
	private String status;
	 @NotNull
	 @NotEmpty(message = "Please enter Order Code")
	private String prorderCode;
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	public String getItemtoManufacture() {
		return itemtoManufacture;
	}
	public void setItemtoManufacture(String itemtoManufacture) {
		this.itemtoManufacture = itemtoManufacture;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProrderCode() {
		return prorderCode;
	}
	public void setProrderCode(String prorderCode) {
		this.prorderCode = prorderCode;
	}
	
	
}
