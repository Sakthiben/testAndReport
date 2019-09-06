package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CrmspLeadBean {
	
	private int slineId;
	@NotNull
	@NotEmpty(message = "Please enter personName")
	private String personName;
	@NotNull
	@NotEmpty(message = "Please enter orgName")
	private String orgName;
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	public int getSlineId() {
		return slineId;
	}
	public void setSlineId(int slineId) {
		this.slineId = slineId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
