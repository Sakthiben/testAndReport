package com.karya.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Dinesh Rajput
 *
 */
@Entity
@Table(name="employee001mb")
public class Employee001MB implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sNo")
	private int sNo;
	
	@Column(name="empNumber")
	private String empNumber;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="empDob")
	private String empDob;
	
	@Column(name="empDoj")
	private String empDoj;
	
	@Column(name="empDesign")
	private String empDesign;
	
	@Column(name="empGender")
	private String empGender;
	
	@Column(name="empCompany")
	private String empCompany;
	
	@Column(name="empStatus")
	private String empStatus;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	private department001MB department001mb;
	
	@Column(name="deptName")
	private String deptName;
	
	@Column(name="branch")
	private String branch;
	
	
	
	/*@OneToMany(mappedBy="employee001mb")
	private Set<Attendance001MB> attendance001mb;

	

	public Set<Attendance001MB> getAttendance001mb() {
		return attendance001mb;
	}

	public void setAttendance001mb(Set<Attendance001MB> attendance001mb) {
		this.attendance001mb = attendance001mb;
	}*/

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public department001MB getDepartment001mb() {
		return department001mb;
	}

	public void setDepartment001mb(department001MB department001mb) {
		this.department001mb = department001mb;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
	
}
