package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TerritoryBean {
	private int terId;
	@NotNull
	@NotEmpty(message = "Please enter territoryName")
	
	private String terName;
	public int getTerId() {
		return terId;
	}
	public void setTerId(int terId) {
		this.terId = terId;
	}
	public String getTerName() {
		return terName;
	}
	public void setTerName(String terName) {
		this.terName = terName;
	}
	
	

}
