package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empsalaryregister001mb")
public class EmploySalaryRegisterReport001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "esregId")
	private int esregId;
	
	@Column(name="salslipCode")
	private String salslipCode;
	
	@Column(name="empNumber")
	private String empNumber;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="deptName")
	private String deptName;
	
		
	@Column(name="empDesign")
	private String empDesign;
	
	@Column(name="empCompany")
	private String empCompany;
	
	@Column(name="salarymonth")
	private String salarymonth;
	
	
	
	
	@Column(name="salYear")
	private String salYear;
	
		
	@Column(name="lvwoutPay")
	private String lvwoutPay;
	
	@Column(name="paymentDays")
	private String paymentDays;
	
	@Column(name="incomeTax")
	private String incomeTax;
	
	
	@Column(name="basic")
	private String basic;
	
		
	@Column(name="arrearAmt")
	private String arrearAmt;
	
	@Column(name="lvencashAmt")
	private String lvencashAmt;
	
	@Column(name="grossPay")
	private String grossPay;

	@Column(name="totalDeduct")
	private String totalDeduct;
	
	@Column(name="netPay")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
