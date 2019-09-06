package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LeaveBlockListBean {
	private int lvblockId;
	@NotNull
	@NotEmpty(message = "Please enter Block Name")
	private String blockName;
	private int sNo;
	@NotNull
	@NotEmpty(message = "Please select the company")
	private String company;
	public int getLvblockId() {
		return lvblockId;
	}
	public void setLvblockId(int lvblockId) {
		this.lvblockId = lvblockId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
