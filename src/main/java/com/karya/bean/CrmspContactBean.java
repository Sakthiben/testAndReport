package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CrmspContactBean {
	
	private int contId;
	@NotNull
	@NotEmpty(message = "Please enter leadName")
	private String leadName;
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	public int getContId() {
		return contId;
	}
	public void setContId(int contId) {
		this.contId = contId;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
