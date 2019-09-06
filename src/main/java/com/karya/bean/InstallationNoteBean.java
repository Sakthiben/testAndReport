package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class InstallationNoteBean {
	
	private int instId;
	
	@NotNull
	@NotEmpty(message = "Please enter the name")
	private String name;
	
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	
	@NotNull
	@NotEmpty(message = "Please enter the remark")
	private String remark;
	
	@NotNull
	@NotEmpty(message = "Please enter the installation code")
	private String instCode;
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	

}
