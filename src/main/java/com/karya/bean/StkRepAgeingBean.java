package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StkRepAgeingBean {
	
	private int stageId;
	@NotNull
	@NotEmpty(message = "Please enter the item")
	
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter the description")
	
	private String description;
	@NotNull
	@NotEmpty(message = "Please enter the item Group")
	
	private String itemGroup;
	@NotNull
	@NotEmpty(message = "Please enter the brand")
	
	private String brand;
	@NotNull
	@NotEmpty(message = "Please enter the average Age")
	
	private String averageAge;
	@NotNull
	@NotEmpty(message = "Please enter the ealiest ageing")
	
	private String earliest;
	@NotNull
	@NotEmpty(message = "Please enter the latest ageing")
	
	private String latest;
	@NotNull
	@NotEmpty(message = "Please mention UOM")
	
	private String UOM;
	public int getStageId() {
		return stageId;
	}
	public void setStageId(int stageId) {
		this.stageId = stageId;
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
	public String getAverageAge() {
		return averageAge;
	}
	public void setAverageAge(String averageAge) {
		this.averageAge = averageAge;
	}
	public String getEarliest() {
		return earliest;
	}
	public void setEarliest(String earliest) {
		this.earliest = earliest;
	}
	public String getLatest() {
		return latest;
	}
	public void setLatest(String latest) {
		this.latest = latest;
	}
	public String getUOM() {
		return UOM;
	}
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	

}
