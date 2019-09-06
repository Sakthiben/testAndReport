package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class InactiveCustBean {
	private int inactcustId;
	@NotNull
	@NotEmpty(message = "Please select customer type")
	
	
	private String custType;
	@NotNull
	@NotEmpty(message = "Please select customer name")
	
	
	private String customername;
	@NotNull
	@NotEmpty(message = "Please select territory")
	
	
	private String terName;
	@NotNull
	@NotEmpty(message = "Please select customer group")
	
	
	private String customergroup;
	@NotNull
	@NotEmpty(message = "Please mention the number of order")
	
	
	private String numoforder;
	@NotNull
	@NotEmpty(message = "Please enter total order value")
	
	
	private String totalordval;
	@NotNull
	@NotEmpty(message = "Please enter total order considered")
	
	
	private String totalordcons;
	@NotNull
	@NotEmpty(message = "Please enter last order amount")
	
	
	private String lastordamt;
	@NotNull
	@NotEmpty(message = "Please specify last order date")
	
	
	private String lastorddate;
	@NotNull
	@NotEmpty(message = "Please enter days last ordered")
	
	
	private String daysinlstord;
	
	public String getDaysinlstord() {
		return daysinlstord;
	}
	public void setDaysinlstord(String daysinlstord) {
		this.daysinlstord = daysinlstord;
	}
	public int getInactcustId() {
		return inactcustId;
	}
	public void setInactcustId(int inactcustId) {
		this.inactcustId = inactcustId;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getTerName() {
		return terName;
	}
	public void setTerName(String terName) {
		this.terName = terName;
	}
	public String getCustomergroup() {
		return customergroup;
	}
	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}
	public String getNumoforder() {
		return numoforder;
	}
	public void setNumoforder(String numoforder) {
		this.numoforder = numoforder;
	}
	public String getTotalordval() {
		return totalordval;
	}
	public void setTotalordval(String totalordval) {
		this.totalordval = totalordval;
	}
	public String getTotalordcons() {
		return totalordcons;
	}
	public void setTotalordcons(String totalordcons) {
		this.totalordcons = totalordcons;
	}
	public String getLastordamt() {
		return lastordamt;
	}
	public void setLastordamt(String lastordamt) {
		this.lastordamt = lastordamt;
	}
	public String getLastorddate() {
		return lastorddate;
	}
	public void setLastorddate(String lastorddate) {
		this.lastorddate = lastorddate;
	}
	

}
