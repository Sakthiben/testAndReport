package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OpenProductionOrderBean {
	
	private int prodId;
	 @NotNull
	 @NotEmpty(message = "Please select the PROrder Code")
	private String prorderCode;
	 @NotNull
	 @NotEmpty(message = "Please enter the Date")
	private String date;
	 @NotNull
	 @NotEmpty(message = "Please select the Item to manufacture")
	private String itemtoManufacture;
	 @NotNull
	 @NotEmpty(message = "Please enter to produce")
	private String toProduce;
	 @NotNull
	 @NotEmpty(message = "Please enter the Produced")
	private String produced;
	 @NotNull
	 @NotEmpty(message = "Please enter the empcompany")
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
