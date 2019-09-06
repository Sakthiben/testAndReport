package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="setupcugrp001mb")
public class CustomerGroup001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cugrpId")
	private int cugrpId;
	
	@Column(name="customergroup")
	private String customergroup;
	
	@Column(name="salesPerson")
	private String salesPerson;

	public int getCugrpId() {
		return cugrpId;
	}

	public void setCugrpId(int cugrpId) {
		this.cugrpId = cugrpId;
	}

	public String getCustomergroup() {
		return customergroup;
	}

	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
