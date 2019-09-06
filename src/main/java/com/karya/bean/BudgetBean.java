package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BudgetBean {
	
	private int bgId;
	
	@NotNull
	 @NotEmpty(message = "Please enter budget name")
	private String budgetName;
	
	@NotNull
	 @NotEmpty(message = "Please select document status")
	private String docStatus;
	
	@NotNull
	 @NotEmpty(message = "Please select center name")
	private String centerName;
	
	@NotNull
	 @NotEmpty(message = "Please warn if annual bidget exceed")
	private String actifannualbgexceed;
	
	@NotNull
	 @NotEmpty(message = "Please warn if monthly budget exceed")
	private String actifmonthbgexceed;
	
	@NotNull
	 @NotEmpty(message = "Please enter year")
	private String fiscalYear;
	
	@NotNull
	 @NotEmpty(message = "Please enter company")
	private String company;
	
	@NotNull
	 @NotEmpty(message = "Please select budget account type")
	private String bgaccountType;
	
	private String bgAmount;
	public int getBgId() {
		return bgId;
	}
	public void setBgId(int bgId) {
		this.bgId = bgId;
	}
	public String getBudgetName() {
		return budgetName;
	}
	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getActifannualbgexceed() {
		return actifannualbgexceed;
	}
	public void setActifannualbgexceed(String actifannualbgexceed) {
		this.actifannualbgexceed = actifannualbgexceed;
	}
	public String getActifmonthbgexceed() {
		return actifmonthbgexceed;
	}
	public void setActifmonthbgexceed(String actifmonthbgexceed) {
		this.actifmonthbgexceed = actifmonthbgexceed;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBgaccountType() {
		return bgaccountType;
	}
	public void setBgaccountType(String bgaccountType) {
		this.bgaccountType = bgaccountType;
	}
	public String getBgAmount() {
		return bgAmount;
	}
	public void setBgAmount(String bgAmount) {
		this.bgAmount = bgAmount;
	}
	
	

}
