package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippingrule001mb")

public class ShippingRule001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sruleId")
	private int sruleId;
	
	@Column(name="sruleName")
	private String sruleName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="sruleLabel")
	private String sruleLabel;

	public int getSruleId() {
		return sruleId;
	}

	public void setSruleId(int sruleId) {
		this.sruleId = sruleId;
	}

	public String getSruleName() {
		return sruleName;
	}

	public void setSruleName(String sruleName) {
		this.sruleName = sruleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSruleLabel() {
		return sruleLabel;
	}

	public void setSruleLabel(String sruleLabel) {
		this.sruleLabel = sruleLabel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	



}
