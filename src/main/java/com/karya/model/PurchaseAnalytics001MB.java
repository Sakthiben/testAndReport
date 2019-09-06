package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="puranalytics001mb")

public class PurchaseAnalytics001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "puansId")
	private int puansId;
	
	@Column(name="treeType")
	private String treeType;
	
	@Column(name="company")
	private String company;
	
	@Column(name="valueorqty")
	private String valueorqty;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="anRange")
	private String anRange;
	
	@Column(name="basedOn")
	private String basedOn;
	

	public String getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(String basedOn) {
		this.basedOn = basedOn;
	}

	public int getPuansId() {
		return puansId;
	}

	public void setPuansId(int puansId) {
		this.puansId = puansId;
	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getValueorqty() {
		return valueorqty;
	}

	public void setValueorqty(String valueorqty) {
		this.valueorqty = valueorqty;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAnRange() {
		return anRange;
	}

	public void setAnRange(String anRange) {
		this.anRange = anRange;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
