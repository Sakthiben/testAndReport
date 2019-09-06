package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="landcostvouch001mb")
public class LandCostCoucher001MB implements Serializable{

private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vouchId")
	private int vouchId;
	
	@Column(name="series")
	private String series;
	
	@Column(name="company")
	private String company;
	
	@Column(name="recptdocType")
	private String recptdocType;
	
	@Column(name="recptdoc")
	private String recptdoc;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="grandTotal")
	private String grandTotal;

	public int getVouchId() {
		return vouchId;
	}

	public void setVouchId(int vouchId) {
		this.vouchId = vouchId;
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

	public String getRecptdocType() {
		return recptdocType;
	}

	public void setRecptdocType(String recptdocType) {
		this.recptdocType = recptdocType;
	}

	public String getRecptdoc() {
		return recptdoc;
	}

	public void setRecptdoc(String recptdoc) {
		this.recptdoc = recptdoc;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
