package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AppraisalBean {
	
	private int apprId;
	 @NotNull
	 @NotEmpty(message = "Please enter the Series")
	private String series;
	 @NotNull
	 @NotEmpty(message = "Please select the appraisal Temp")
	private String appraisalTemp;
	public int getApprId() {
		return apprId;
	}
	public void setApprId(int apprId) {
		this.apprId = apprId;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getAppraisalTemp() {
		return appraisalTemp;
	}
	public void setAppraisalTemp(String appraisalTemp) {
		this.appraisalTemp = appraisalTemp;
	}
	
	

}
