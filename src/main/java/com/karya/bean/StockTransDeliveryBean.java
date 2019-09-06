package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockTransDeliveryBean {
	private int stdelId;
	@NotNull
	@NotEmpty(message = "Please enter the Title")
	
	private String title;
	@NotNull
	@NotEmpty(message = "Please select the status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please enter the grand Total")
	
	private String grandTotal;
	@NotNull
	@NotEmpty(message = "Please enter the delivery code")
	
	private String delName;
	public int getStdelId() {
		return stdelId;
	}
	public void setStdelId(int stdelId) {
		this.stdelId = stdelId;
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
	public String getDelName() {
		return delName;
	}
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	

}
