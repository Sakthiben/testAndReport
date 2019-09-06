package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PaymentRequestBean {
	private int payreqId;
	
	@NotNull
	@NotEmpty(message= "Please enter name")
	private String prName;
	
	@NotNull
	@NotEmpty(message= "Please enter status")
	private String status;
	public int getPayreqId() {
		return payreqId;
	}
	public void setPayreqId(int payreqId) {
		this.payreqId = payreqId;
	}
	public String getPrName() {
		return prName;
	}
	public void setPrName(String prName) {
		this.prName = prName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
