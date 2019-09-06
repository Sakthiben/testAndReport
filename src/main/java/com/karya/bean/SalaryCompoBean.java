package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SalaryCompoBean {
	
	private int salcompId;
	 @NotNull
	 @NotEmpty(message = "Please enter Componenet Name")
	private String comName;
	 @NotNull
	 @NotEmpty(message = "Please enter Abbreviations")
	private String abbr;
	public int getSalcompId() {
		return salcompId;
	}
	public void setSalcompId(int salcompId) {
		this.salcompId = salcompId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	

}
