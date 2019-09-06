package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CrmMinTimeRespBean {
	
	private int mrpId;
	@NotNull
	@NotEmpty(message = "Please specify the date")
	private String date;
	@NotNull
	 @NotEmpty(message = "Please enter the response minute")
	
	private String mintoresp;
	public int getMrpId() {
		return mrpId;
	}
	public void setMrpId(int mrpId) {
		this.mrpId = mrpId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMintoresp() {
		return mintoresp;
	}
	public void setMintoresp(String mintoresp) {
		this.mintoresp = mintoresp;
	}
	
	

}
