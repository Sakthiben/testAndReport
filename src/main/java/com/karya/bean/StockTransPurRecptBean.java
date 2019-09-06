package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockTransPurRecptBean {
	private int stpurtId;
	@NotNull
	@NotEmpty(message = "Please enter the title")
	
	private String title;
	@NotNull
	@NotEmpty(message = "Please select the status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please enter the grand Total")
	
	private String grandTotal;
	@NotNull
	@NotEmpty(message = "Please enter the purchase Receipt Code")
	
	private String purtName;
	public int getStpurtId() {
		return stpurtId;
	}
	public void setStpurtId(int stpurtId) {
		this.stpurtId = stpurtId;
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
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getPurtName() {
		return purtName;
	}
	public void setPurtName(String purtName) {
		this.purtName = purtName;
	}
	
	
	
	

}
