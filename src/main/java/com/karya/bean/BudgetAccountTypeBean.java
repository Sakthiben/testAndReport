package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BudgetAccountTypeBean {
	
	private int bgaccId;
	
	@NotNull
	 @NotEmpty(message = "Please enter budget account type")
	private String bgaccountType;
	public int getBgaccId() {
		return bgaccId;
	}
	public void setBgaccId(int bgaccId) {
		this.bgaccId = bgaccId;
	}
	public String getBgaccountType() {
		return bgaccountType;
	}
	public void setBgaccountType(String bgaccountType) {
		this.bgaccountType = bgaccountType;
	}
	

}
