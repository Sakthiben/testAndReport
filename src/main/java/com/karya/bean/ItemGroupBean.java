package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemGroupBean {
	private int igId;
	@NotNull
	 @NotEmpty(message = "Please enter itemGroup")
	private String itemGroup;
	public int getIgId() {
		return igId;
	}
	public void setIgId(int igId) {
		this.igId = igId;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	

}
