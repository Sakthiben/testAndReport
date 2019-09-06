package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmploymentTypeBean {
	
	private int etypeId;
	 @NotNull
	 @NotEmpty(message = "Please enter Employment Type")
	private String employmentType;
	public int getEtypeId() {
		return etypeId;
	}
	public void setEtypeId(int etypeId) {
		this.etypeId = etypeId;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	

}
