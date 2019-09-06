package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeBean {
	private int sNo;
	@NotNull
	@NotEmpty(message = "Please enter employee code")
	private String empNumber;
	@NotNull
	 @NotEmpty(message = "Please enter employee name")
	private String empName;
	@NotNull
	 @NotEmpty(message = "Please enter employee date of birth")
	private String empDob;
	@NotNull
	 @NotEmpty(message = "Please enter employee data of joining")
	private String empDoj;
	@NotNull
	 @NotEmpty(message = "Please enter employee desigination")
	private String empDesign;
	@NotNull
	 @NotEmpty(message = "Please enter employee gender")
	private String empGender;
	@NotNull
	 @NotEmpty(message = "Please enter employee company")
	private String empCompany;
	@NotNull
	 @NotEmpty(message = "Please select employee status")
	private String empStatus;
	@NotNull
	private int deptId;
	@NotNull
	 @NotEmpty(message = "Please select department")
	private String deptName;
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@NotNull
	 @NotEmpty(message = "Please enter employee branch")
	private String branch;
	
	
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
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
	public String getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
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
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	
}
