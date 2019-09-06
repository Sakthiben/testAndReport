package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AssetMovementBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String transactiondate;
	
	@NotNull
	@NotEmpty(message = "Please Select Asset Name")
	private String asset;
	
	@NotNull
	@NotEmpty(message = "Please Enter Company")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please Enter TargetWarehouse")
	private String targetwarehouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTargetwarehouse() {
		return targetwarehouse;
	}

	public void setTargetwarehouse(String targetwarehouse) {
		this.targetwarehouse = targetwarehouse;
	}
	
}
