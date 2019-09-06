package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class HolidayListBean {
	
	private int hlistId;
	@NotNull
	@NotEmpty(message = "Please enter the holiday name")
	private String holidayName;
	@NotNull
	@NotEmpty(message = "Please select the Weekly Off")
	private String weeklyOff;
	public int getHlistId() {
		return hlistId;
	}
	public void setHlistId(int hlistId) {
		this.hlistId = hlistId;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public String getWeeklyOff() {
		return weeklyOff;
	}
	public void setWeeklyOff(String weeklyOff) {
		this.weeklyOff = weeklyOff;
	}
	
	

}
