package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployWorkHolidayReportBean {
	
	private int empwhId;
	
	@NotNull
	@NotEmpty(message = "Please enter from date")
	private String fromDate;
	
	@NotNull
	@NotEmpty(message = "Please enter to date")
	private String toDate;
	
	@NotNull
	@NotEmpty(message = "Please enter the year")
	private String holidayList;
	
	@NotNull
	@NotEmpty(message = "Please enter employee number")
	private String empNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter employee name")
	private String empName;
	
	@NotNull
	@NotEmpty(message = "Please enter date")
	private String whDate;
	
	@NotNull
	@NotEmpty(message = "Please select employee status")
	private String empStatus;
	
	@NotNull
	@NotEmpty(message = "Please specify the day")
	private String holiday;
	public int getEmpwhId() {
		return empwhId;
	}
	public void setEmpwhId(int empwhId) {
		this.empwhId = empwhId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getHolidayList() {
		return holidayList;
	}
	public void setHolidayList(String holidayList) {
		this.holidayList = holidayList;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getWhDate() {
		return whDate;
	}
	public void setWhDate(String whDate) {
		this.whDate = whDate;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	

}
