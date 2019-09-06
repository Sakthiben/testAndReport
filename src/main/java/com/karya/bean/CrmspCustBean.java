package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CrmspCustBean {
	private int custId;
	@NotNull
	@NotEmpty(message = "Please enter customername")
	private String customername;
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	@NotNull
	@NotEmpty(message = "Please enter customergroup")
	private String customergroup;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomergroup() {
		return customergroup;
	}
	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}
	

}
