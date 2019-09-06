package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OperationBOMBean {
	private int opId;
	@NotNull
	@NotEmpty(message= "please enter operation name")
	private String opName;
	@NotNull
	@NotEmpty(message= "please enter operation name")
	private String workstName;
	public int getOpId() {
		return opId;
	}
	public void setOpId(int opId) {
		this.opId = opId;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getWorkstName() {
		return workstName;
	}
	public void setWorkstName(String workstName) {
		this.workstName = workstName;
	}
	
	

}
