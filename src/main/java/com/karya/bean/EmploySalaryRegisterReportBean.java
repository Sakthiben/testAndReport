package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmploySalaryRegisterReportBean {
	
	private int esregId;
	
	@NotNull
	@NotEmpty(message = "Please enter salary slip number")
	private String salslipCode;
	
	@NotNull
	@NotEmpty(message = "Please enter employee number")
	private String empNumber;
	
	@NotNull
	@NotEmpty(message = "Please enter employee name")
	private String empName;
	
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
	@NotEmpty(message = "Please enter employee company")
	private String empCompany;
	
	@NotNull
	@NotEmpty(message = "Please enter employee salary month")
	private String salarymonth;
	
	@NotNull
	@NotEmpty(message = "Please enter year")
	private String salYear;
	
	private String lvwoutPay;
	
	private String paymentDays;
	
	private String incomeTax;
	
	private String basic;
	
	private String arrearAmt;
	
	private String lvencashAmt;
	
	private String grossPay;
	
	private String totalDeduct;
	
	private String netPay;
	
	public int getEsregId() {
		return esregId;
	}
	public void setEsregId(int esregId) {
		this.esregId = esregId;
	}
	public String getSalslipCode() {
		return salslipCode;
	}
	public void setSalslipCode(String salslipCode) {
		this.salslipCode = salslipCode;
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
	public String getEmpDesign() {
		return empDesign;
	}
	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}
	public String getEmpCompany() {
		return empCompany;
	}
	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}
	public String getSalarymonth() {
		return salarymonth;
	}
	public void setSalarymonth(String salarymonth) {
		this.salarymonth = salarymonth;
	}
	public String getSalYear() {
		return salYear;
	}
	public void setSalYear(String salYear) {
		this.salYear = salYear;
	}
	public String getLvwoutPay() {
		return lvwoutPay;
	}
	public void setLvwoutPay(String lvwoutPay) {
		this.lvwoutPay = lvwoutPay;
	}
	public String getPaymentDays() {
		return paymentDays;
	}
	public void setPaymentDays(String paymentDays) {
		this.paymentDays = paymentDays;
	}
	public String getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getArrearAmt() {
		return arrearAmt;
	}
	public void setArrearAmt(String arrearAmt) {
		this.arrearAmt = arrearAmt;
	}
	public String getLvencashAmt() {
		return lvencashAmt;
	}
	public void setLvencashAmt(String lvencashAmt) {
		this.lvencashAmt = lvencashAmt;
	}
	public String getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(String grossPay) {
		this.grossPay = grossPay;
	}
	public String getTotalDeduct() {
		return totalDeduct;
	}
	public void setTotalDeduct(String totalDeduct) {
		this.totalDeduct = totalDeduct;
	}
	public String getNetPay() {
		return netPay;
	}
	public void setNetPay(String netPay) {
		this.netPay = netPay;
	}
	
	
	

}
