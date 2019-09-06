package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProdStockEntryBean {
	
	private int prstockId;
	 @NotNull
	 @NotEmpty(message = "Please enter Title")
	private String title;
	 @NotNull
	 @NotEmpty(message = "Please Select Status")
	private String status;
	 @NotNull
	 @NotEmpty(message = "Please enter Purpose")
	private String purpose;
	 @NotNull
	 @NotEmpty(message = "Please enter Stock entry")
	private String stockEntry;
	public int getPrstockId() {
		return prstockId;
	}
	public void setPrstockId(int prstockId) {
		this.prstockId = prstockId;
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
	public String getStockEntry() {
		return stockEntry;
	}
	public void setStockEntry(String stockEntry) {
		this.stockEntry = stockEntry;
	}
	

}
