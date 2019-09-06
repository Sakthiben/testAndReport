package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockTransEntryBean {
	private int stentid;
	@NotNull
	@NotEmpty(message = "Please enter the Title")
	
	private String title;
	@NotNull
	@NotEmpty(message = "Please select the status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please select purpose")
	
	private String purpose;
	@NotNull
	@NotEmpty(message = "Please enter the stock Name")
	
	private String stName;
	public int getStentid() {
		return stentid;
	}
	public void setStentid(int stentid) {
		this.stentid = stentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	
	
	

}
