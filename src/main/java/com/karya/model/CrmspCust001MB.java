package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crmspcust001mb")
public class CrmspCust001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;
	
	@Column(name="customername")
	private String customername;
	
	@Column(name="status")
	private String status;
	
	@Column(name="customergroup")
	private String customergroup;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomergroup() {
		return customergroup;
	}

	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
