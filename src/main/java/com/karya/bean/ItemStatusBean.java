package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemStatusBean {
	private int itemstId;
	@NotNull
	@NotEmpty(message="please select item")
	private String itemCode;
	@NotNull
	@NotEmpty(message="please select status")
	private String status;
	@NotNull
	@NotEmpty(message="please select itemGroup")
	private String itemGroup;
	public int getItemstId() {
		return itemstId;
	}
	public void setItemstId(int itemstId) {
		this.itemstId = itemstId;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	

}
