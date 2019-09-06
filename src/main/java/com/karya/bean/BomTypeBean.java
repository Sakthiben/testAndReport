package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BomTypeBean {
	
	private int bomId;
	 @NotNull
	 @NotEmpty(message = "Please enter Bom Name")
	private String bomName;
	 @NotNull
	 @NotEmpty(message = "Please enter Bom Type")
	private String bomType;
	public int getBomId() {
		return bomId;
	}
	public void setBomId(int bomId) {
		this.bomId = bomId;
	}
	public String getBomName() {
		return bomName;
	}
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}
	public String getBomType() {
		return bomType;
	}
	public void setBomType(String bomType) {
		this.bomType = bomType;
	}
	

}
