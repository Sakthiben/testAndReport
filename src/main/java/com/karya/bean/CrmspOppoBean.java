package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CrmspOppoBean {
	private int oppId;
	@NotNull
	@NotEmpty(message = "Please enter Series")
	private String oppSeries;
	@NotNull
	@NotEmpty(message = "Please enter Type")
	private String oppType;
	@NotNull
	@NotEmpty(message = "Please enter Source")
	private String oppFrom;
	@NotNull
	@NotEmpty(message = "Please select status")
	private String status;
	private boolean withitems;
	public int getOppId() {
		return oppId;
	}
	public void setOppId(int oppId) {
		this.oppId = oppId;
	}
	public String getOppSeries() {
		return oppSeries;
	}
	public void setOppSeries(String oppSeries) {
		this.oppSeries = oppSeries;
	}
	public String getOppType() {
		return oppType;
	}
	public void setOppType(String oppType) {
		this.oppType = oppType;
	}
	public String getOppFrom() {
		return oppFrom;
	}
	public void setOppFrom(String oppFrom) {
		this.oppFrom = oppFrom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isWithitems() {
		return withitems;
	}
	public void setWithitems(boolean withitems) {
		this.withitems = withitems;
	}
	
}
