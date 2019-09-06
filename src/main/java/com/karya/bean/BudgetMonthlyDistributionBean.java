package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BudgetMonthlyDistributionBean {
	
	private int bmdId;
	
	@NotNull
	 @NotEmpty(message = "Please enter monthly distribution code")
	private String distName;
	
	@NotNull
	 @NotEmpty(message = "Please enter fiscal year")
	private String fiscalYear;
	
	@NotNull
	 @NotEmpty(message = "Please select respective month")
	private String respMonth;
	
	private String percentAllocate;
	public int getBmdId() {
		return bmdId;
	}
	public void setBmdId(int bmdId) {
		this.bmdId = bmdId;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getRespMonth() {
		return respMonth;
	}
	public void setRespMonth(String respMonth) {
		this.respMonth = respMonth;
	}
	public String getPercentAllocate() {
		return percentAllocate;
	}
	public void setPercentAllocate(String percentAllocate) {
		this.percentAllocate = percentAllocate;
	}
	

}
