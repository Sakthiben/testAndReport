package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appraisal001mb")
public class Appraisal001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "apprId")
	private int apprId;
	
	@Column(name="series")
	private String series;
	
	@Column(name="appraisalTemp")
	private String appraisalTemp;

	public int getApprId() {
		return apprId;
	}

	public void setApprId(int apprId) {
		this.apprId = apprId;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getAppraisalTemp() {
		return appraisalTemp;
	}

	public void setAppraisalTemp(String appraisalTemp) {
		this.appraisalTemp = appraisalTemp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
