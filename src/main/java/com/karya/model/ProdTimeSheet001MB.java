package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodtimesheet001mb")

public class ProdTimeSheet001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prtId")
	private int prtId;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="tsName")
	private String tsName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="empCompany")
	private String empCompany;

	@Column(name="twhrs")
	private String twhrs;

	public int getPrtId() {
		return prtId;
	}

	public void setPrtId(int prtId) {
		this.prtId = prtId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTsName() {
		return tsName;
	}

	public void setTsName(String tsName) {
		this.tsName = tsName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public String getTwhrs() {
		return twhrs;
	}

	public void setTwhrs(String twhrs) {
		this.twhrs = twhrs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
