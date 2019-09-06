package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CostCenterBean {
	
	private int centId;
	
	@NotNull
	 @NotEmpty(message = "Please enter cost center")
	private String centerName;

	public int getCentId() {
		return centId;
	}

	public void setCentId(int centId) {
		this.centId = centId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	

}
