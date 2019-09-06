package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountChartBean {

	private int chartId;
	
	@NotNull
	 @NotEmpty(message = "Please enter chart name")
	private String chartName;
	public int getChartId() {
		return chartId;
	}
	public void setChartId(int chartId) {
		this.chartId = chartId;
	}
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	
}
