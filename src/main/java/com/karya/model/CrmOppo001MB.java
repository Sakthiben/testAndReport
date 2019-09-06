package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crmspoppo001mb")
public class CrmOppo001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "oppId")
	private int oppId;
	
	@Column(name="oppSeries")
	private String oppSeries;
	
	@Column(name="oppType")
	private String oppType;
	
	@Column(name="oppFrom")
	private String oppFrom;
	
	@Column(name="status")
	private String status;
	
	@Column(name="withitems")
	private boolean withitems;

	public int getOppId() {
		return oppId;
	}

	public void setOppId(int oppId) {
		this.oppId = oppId;
	}

	public String getOppSeries() {
		return oppSeries;
	}

	public void setOppSeries(String oppSeries) {
		this.oppSeries = oppSeries;
	}

	public String getOppType() {
		return oppType;
	}

	public void setOppType(String oppType) {
		this.oppType = oppType;
	}

	public String getOppFrom() {
		return oppFrom;
	}

	public void setOppFrom(String oppFrom) {
		this.oppFrom = oppFrom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public boolean isWithitems() {
		return withitems;
	}

	public void setWithitems(boolean withitems) {
		this.withitems = withitems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
