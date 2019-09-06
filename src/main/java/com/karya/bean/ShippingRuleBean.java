package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ShippingRuleBean {
	
	private int sruleId;
	@NotNull
	@NotEmpty(message = "Please enter the Shipping Name")
	
	private String sruleName;
	@NotNull
	@NotEmpty(message = "Please select status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please enter the Label Name")
	
	private String sruleLabel;
	public int getSruleId() {
		return sruleId;
	}
	public void setSruleId(int sruleId) {
		this.sruleId = sruleId;
	}
	public String getSruleName() {
		return sruleName;
	}
	public void setSruleName(String sruleName) {
		this.sruleName = sruleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSruleLabel() {
		return sruleLabel;
	}
	public void setSruleLabel(String sruleLabel) {
		this.sruleLabel = sruleLabel;
	}
	

}
