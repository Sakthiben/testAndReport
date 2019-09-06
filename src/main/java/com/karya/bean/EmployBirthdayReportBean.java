package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployBirthdayReportBean {
	
	private int empbirthId;
	
	@NotNull
	@NotEmpty(message = "Please enter month")
	private String ebmonth;
	
	@NotNull
	@NotEmpty(message = "Please enter employee number")
	private String empNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter employee name")
	private String empName;
	
	@NotNull
	@NotEmpty(message = "Please enter employee DOB")
	private String empDob;
	
	@NotNull
	@NotEmpty(message = "Please enter employee branch")
	private String branch;
	
	@NotNull
	@NotEmpty(message = "Please enter employee department")
	private String deptName;
	
	@NotNull
	@NotEmpty(message = "Please enter employee designation")
	private String empDesign;
	
	@NotNull
	@NotEmpty(message = "Please enter employee gender")
	private String empGender;
	
	@NotNull
	@NotEmpty(message = "Please enter employee company")
	private String empCompany;
	public int getEmpbirthId() {
		return empbirthId;
	}
	public void setEmpbirthId(int empbirthId) {
		this.empbirthId = empbirthId;
	}
	public String getEbmonth() {
		return ebmonth;
	}
	public void setEbmonth(String ebmonth) {
		this.ebmonth = ebmonth;
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
	public String getEmpDob() {
		return empDob;
	}
	public void setEmpDob(String empDob) {
		this.empDob = empDob;
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
	public String getEmpDesign() {
		return empDesign;
	}
	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpCompany() {
		return empCompany;
	}
	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}
	
	

}
