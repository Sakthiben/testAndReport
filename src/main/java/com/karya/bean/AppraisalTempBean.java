package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AppraisalTempBean {
	private int apptmpId;
	 @NotNull
	 @NotEmpty(message = "Please enter Appraisal Template")
	private String appraisalTemp;
	 @NotNull
	 @NotEmpty(message = "Please enter description")
	private String description;
	public int getApptmpId() {
		return apptmpId;
	}
	public void setApptmpId(int apptmpId) {
		this.apptmpId = apptmpId;
	}
	public String getAppraisalTemp() {
		return appraisalTemp;
	}
	public void setAppraisalTemp(String appraisalTemp) {
		this.appraisalTemp = appraisalTemp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
