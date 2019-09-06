package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="empleavebalance001mb")
public class EmployeeLeaveBalanceReport001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "elbId")
	private int elbId;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="company")
	private String company;
	
	@Column(name="empNumber")
	private String empNumber;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="deptName")
	private String deptName;
	
	@Column(name="clTaken")
	private String clTaken;
	
	@Column(name="clBalance")
	private String clBalance;
	
	@Column(name="compoffTaken")
	private String compoffTaken;
	
	@Column(name="compoffBalance")
	private String compoffBalance;
	
	@Column(name="lvwoutpayTaken")
	private String lvwoutpayTaken;
	
	@Column(name="lvwoutpayBalance")
	private String lvwoutpayBalance;
	
	@Column(name="plTaken")
	private String plTaken;
	
	@Column(name="plBalance")
	private String plBalance;
	
	@Column(name="slTaken")
	private String slTaken;
	
	
	
	
	@Column(name="slBalance")
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




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
