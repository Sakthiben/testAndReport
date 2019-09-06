package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SalaryStructBean {
	
	private int strId;
	 @NotNull
	 @NotEmpty(message = "Please Select Employee Name")
	private String empName;
	 @NotNull
	 @NotEmpty(message = "Please select the Salary Mode")
	private String isActive;
	 @NotNull
	 @NotEmpty(message = "Please enter the Date")
	private String fromDate;
	/*private Integer sNo;
	*/public int getStrId() {
		return strId;
	}
	public void setStrId(int strId) {
		this.strId = strId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/*public Integer getsNo() {
		return sNo;
	}
	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}
	*/
	

}
