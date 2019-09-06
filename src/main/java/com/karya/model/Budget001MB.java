package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budget001mb")
public class Budget001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bgId")
	private int bgId;
	
	@Column(name="budgetName")
	private String budgetName;
	
	@Column(name="docStatus")
	private String docStatus;
	
	@Column(name="centerName")
	private String centerName;
	
	@Column(name="actifannualbgexceed")
	private String actifannualbgexceed;
	
	@Column(name="actifmonthbgexceed")
	private String actifmonthbgexceed;
	
	@Column(name="fiscalYear")
	private String fiscalYear;
	
	@Column(name="company")
	private String company;
	
	@Column(name="bgaccountType")
	private String bgaccountType;
	
	@Column(name="bgAmount")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
