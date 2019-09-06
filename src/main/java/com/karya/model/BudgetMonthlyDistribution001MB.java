package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budgetmonthdist001mb")
public class BudgetMonthlyDistribution001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bmdId")
	private int bmdId;
	
	@Column(name="distName")
	private String distName;
	
	@Column(name="fiscalYear")
	private String fiscalYear;
	
	@Column(name="respMonth")
	private String respMonth;
	
	@Column(name="percentAllocate")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
