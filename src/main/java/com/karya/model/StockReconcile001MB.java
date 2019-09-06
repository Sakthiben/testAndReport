package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stkreconcile001mb")
public class StockReconcile001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stkrecId")
	private int stkrecId;
	
	@Column(name="series")
	private String series;
	
	@Column(name="company")
	private String company;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="postingTime")
	private String postingTime;
	
	@Column(name="diffAcc")
	private String diffAcc;
	
	@Column(name="costCenter")
	private String costCenter;

	public int getStkrecId() {
		return stkrecId;
	}

	public void setStkrecId(int stkrecId) {
		this.stkrecId = stkrecId;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getPostingTime() {
		return postingTime;
	}

	public void setPostingTime(String postingTime) {
		this.postingTime = postingTime;
	}

	public String getDiffAcc() {
		return diffAcc;
	}

	public void setDiffAcc(String diffAcc) {
		this.diffAcc = diffAcc;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
