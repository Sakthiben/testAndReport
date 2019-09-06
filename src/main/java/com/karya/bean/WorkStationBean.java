package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class WorkStationBean {
	private int workstId;
	@NotNull
	@NotEmpty(message= "please enter workstation")
	private String workstName;
	public int getWorkstId() {
		return workstId;
	}
	public void setWorkstId(int workstId) {
		this.workstId = workstId;
	}
	public String getWorkstName() {
		return workstName;
	}
	public void setWorkstName(String workstName) {
		this.workstName = workstName;
	}
	

}
