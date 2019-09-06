package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LandCostVoucherBean {
	
	private int vouchId;
	
	@NotNull
	@NotEmpty(message = "Please enter the series")
	private String series;
	
	@NotNull
	@NotEmpty(message = "Please enter the company")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please enter the receipt doc type")
	private String recptdocType;
	
	@NotNull
	@NotEmpty(message = "Please enter the receipt doc")
	private String recptdoc;
	
	@NotNull
	@NotEmpty(message = "Please enter the supplier name")
	private String supName;
	
	@NotNull
	@NotEmpty(message = "Please enter the grand total")
	private String grandTotal;
	public int getVouchId() {
		return vouchId;
	}
	public void setVouchId(int vouchId) {
		this.vouchId = vouchId;
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
	public String getRecptdocType() {
		return recptdocType;
	}
	public void setRecptdocType(String recptdocType) {
		this.recptdocType = recptdocType;
	}
	public String getRecptdoc() {
		return recptdoc;
	}
	public void setRecptdoc(String recptdoc) {
		this.recptdoc = recptdoc;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
	

}
