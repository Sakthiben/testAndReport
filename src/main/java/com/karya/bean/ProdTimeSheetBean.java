package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProdTimeSheetBean {

	private int prtId;
	 @NotNull
	 @NotEmpty(message = "Please select Employee Name")
	private String empName;
	 @NotNull
	 @NotEmpty(message = "Please enter time sheet name")
	private String tsName;
	 @NotNull
	 @NotEmpty(message = "Please Select status")
	private String status;
	 @NotNull
	 @NotEmpty(message = "Please select employee company")
	private String empCompany;
	 @NotNull
	 @NotEmpty(message = "Please enter Total Working Hours")
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
	
}
