package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CustomerGroupBean {
	private int cugrpId;
	@NotNull
	@NotEmpty(message = "Please enter customergroup")
	
	private String customergroup;
	@NotNull
	@NotEmpty(message = "Please select SalesPerson")
	
	private String salesPerson;
	public int getCugrpId() {
		return cugrpId;
	}
	public void setCugrpId(int cugrpId) {
		this.cugrpId = cugrpId;
	}
	public String getCustomergroup() {
		return customergroup;
	}
	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	

}
