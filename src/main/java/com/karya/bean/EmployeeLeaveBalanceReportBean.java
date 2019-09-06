package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeLeaveBalanceReportBean {
	
	private int elbId;
	
	@NotNull
	@NotEmpty(message = "Please mention from date")
	private String fromDate;
	
	@NotNull
	@NotEmpty(message = "Please mention to date")
	private String toDate;
	
	@NotNull
	@NotEmpty(message = "Please enter employee company")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please enter employee code")
	private String empNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter employee name")
	private String empName;
	
	@NotNull
	@NotEmpty(message = "Please enter employee branch")
	private String branch;
	
	@NotNull
	@NotEmpty(message = "Please enter department")
	private String deptName;
	
	@NotNull
	@NotEmpty(message = "Please enter casual leave taken")
	private String clTaken;
	
	@NotNull
	@NotEmpty(message = "Please enter casual leave balance")
	private String clBalance;
	
	@NotNull
	@NotEmpty(message = "Please enter compensatory off taken code")
	private String compoffTaken;
	
	@NotNull
	@NotEmpty(message = "Please enter compensatory off  balance")
	private String compoffBalance;
	
	@NotNull
	@NotEmpty(message = "Please enter leave without pay taken")
	private String lvwoutpayTaken;
	
	@NotNull
	@NotEmpty(message = "Please enter leave  without pay balance")
	private String lvwoutpayBalance;
	
	@NotNull
	@NotEmpty(message = "Please enter paternity leave taken")
	private String plTaken;
	
	@NotNull
	@NotEmpty(message = "Please enter paternity leave balance")
	private String plBalance;
	
	@NotNull
	@NotEmpty(message = "Please enter sick leave taken")
	private String slTaken;
	
	@NotNull
	@NotEmpty(message = "Please enter sick leave balance")
	private String slBalance;
	public int getElbId() {
		return elbId;
	}
	public void setElbId(int elbId) {
		this.elbId = elbId;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getClTaken() {
		return clTaken;
	}
	public void setClTaken(String clTaken) {
		this.clTaken = clTaken;
	}
	public String getClBalance() {
		return clBalance;
	}
	public void setClBalance(String clBalance) {
		this.clBalance = clBalance;
	}
	public String getCompoffTaken() {
		return compoffTaken;
	}
	public void setCompoffTaken(String compoffTaken) {
		this.compoffTaken = compoffTaken;
	}
	public String getCompoffBalance() {
		return compoffBalance;
	}
	public void setCompoffBalance(String compoffBalance) {
		this.compoffBalance = compoffBalance;
	}
	public String getLvwoutpayTaken() {
		return lvwoutpayTaken;
	}
	public void setLvwoutpayTaken(String lvwoutpayTaken) {
		this.lvwoutpayTaken = lvwoutpayTaken;
	}
	public String getLvwoutpayBalance() {
		return lvwoutpayBalance;
	}
	public void setLvwoutpayBalance(String lvwoutpayBalance) {
		this.lvwoutpayBalance = lvwoutpayBalance;
	}
	public String getPlTaken() {
		return plTaken;
	}
	public void setPlTaken(String plTaken) {
		this.plTaken = plTaken;
	}
	public String getPlBalance() {
		return plBalance;
	}
	public void setPlBalance(String plBalance) {
		this.plBalance = plBalance;
	}
	public String getSlTaken() {
		return slTaken;
	}
	public void setSlTaken(String slTaken) {
		this.slTaken = slTaken;
	}
	public String getSlBalance() {
		return slBalance;
	}
	public void setSlBalance(String slBalance) {
		this.slBalance = slBalance;
	}
	

}
