package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LeaveTypeBean {

	private int lvtypeId;
	@NotNull
	@NotEmpty(message = "Please select Leave Type")
	private String lvtypeName;
	@NotNull
	@Min(1)
	private int maxdaysAllowed;
	public int getLvtypeId() {
		return lvtypeId;
	}
	public void setLvtypeId(int lvtypeId) {
		this.lvtypeId = lvtypeId;
	}
	public String getLvtypeName() {
		return lvtypeName;
	}
	public void setLvtypeName(String lvtypeName) {
		this.lvtypeName = lvtypeName;
	}
	public int getMaxdaysAllowed() {
		return maxdaysAllowed;
	}
	public void setMaxdaysAllowed(int maxdaysAllowed) {
		this.maxdaysAllowed = maxdaysAllowed;
	}
	
}
