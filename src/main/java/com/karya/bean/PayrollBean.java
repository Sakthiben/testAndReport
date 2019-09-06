package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PayrollBean {
	
	private int prId;
	private int sNo;
	 @NotNull
	 @NotEmpty(message = "Please select the status")
	private String status;
	 @NotNull
	
	private Integer fiscalYear;
	 @NotNull
	 @NotEmpty(message = "Please enter salary slip")
	private String salarySlip;
	 @NotNull
	 @NotEmpty(message = "Please select the employee name")
	private String empName;
	
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(Integer fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getSalarySlip() {
		return salarySlip;
	}
	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	
	
	

}
