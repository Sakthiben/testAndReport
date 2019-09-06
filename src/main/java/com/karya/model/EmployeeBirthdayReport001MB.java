package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employbirthday001mb")
public class EmployeeBirthdayReport001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "empbirthId")
	private int empbirthId;
	
	@Column(name="ebmonth")
	private String ebmonth;
	
	@Column(name="empNumber")
	private String empNumber;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="empDob")
	private String empDob;
	
	@Column(name="branch")
	private String branch;
	
		
	@Column(name="deptName")
	private String deptName;
	
	@Column(name="empDesign")
	private String empDesign;
	
	@Column(name="empGender")
	private String empGender;
	
	@Column(name="empCompany")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
