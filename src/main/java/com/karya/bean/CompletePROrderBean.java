package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CompletePROrderBean {
	
	private int prodId;
	 @NotNull
	 @NotEmpty(message = "Please select PROrder Code")
	private String prorderCode;
	 @NotNull
	 @NotEmpty(message = "Please enter the date")
	private String date;
	 @NotNull
	 @NotEmpty(message = "Please select ItemtoManufacture")
	private String itemtoManufacture;
	 @NotNull
	 @NotEmpty(message = "Please enter to Produce")
	private String toProduce;
	 @NotNull
	 @NotEmpty(message = "Please enter Produced")
	private String produced;
	 @NotNull
	 @NotEmpty(message = "Please enter the Employee company")
	private String empCompany;
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProrderCode() {
		return prorderCode;
	}
	public void setProrderCode(String prorderCode) {
		this.prorderCode = prorderCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getItemtoManufacture() {
		return itemtoManufacture;
	}
	public void setItemtoManufacture(String itemtoManufacture) {
		this.itemtoManufacture = itemtoManufacture;
	}
	public String getToProduce() {
		return toProduce;
	}
	public void setToProduce(String toProduce) {
		this.toProduce = toProduce;
	}
	public String getProduced() {
		return produced;
	}
	public void setProduced(String produced) {
		this.produced = produced;
	}
	public String getEmpCompany() {
		return empCompany;
	}
	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}
	

}
