package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockReconcileBean {
	private int stkrecId;
	
	@NotNull
	@NotEmpty(message = "Please enter the series")
	private String series;
	
	@NotNull
	@NotEmpty(message = "Please enter the company")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please mention posting date")
	private String postingDate;
	
	@NotNull
	@NotEmpty(message = "Please mention posting time")
	private String postingTime;
	
	@NotNull
	@NotEmpty(message = "Please enter the difference account")
	private String diffAcc;
	
	@NotNull
	@NotEmpty(message = "Please enter the cost center source")
	private String costCenter;
	public int getStkrecId() {
		return stkrecId;
	}
	public void setStkrecId(int stkrecId) {
		this.stkrecId = stkrecId;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getPostingTime() {
		return postingTime;
	}
	public void setPostingTime(String postingTime) {
		this.postingTime = postingTime;
	}
	public String getDiffAcc() {
		return diffAcc;
	}
	public void setDiffAcc(String diffAcc) {
		this.diffAcc = diffAcc;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	

}
