package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PackingSlipBean {

	private int psId;
	
	@NotNull
	@NotEmpty(message = "Please enter the packing slip name")
	private String slipName;
	
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	
	@NotNull
	@NotEmpty(message = "Please enter the delivery note")
	private String delName;
	public int getPsId() {
		return psId;
	}
	public void setPsId(int psId) {
		this.psId = psId;
	}
	public String getSlipName() {
		return slipName;
	}
	public void setSlipName(String slipName) {
		this.slipName = slipName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelName() {
		return delName;
	}
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	
}
