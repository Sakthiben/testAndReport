package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supstatus001mb")
public class SupplierStatus001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sustatusId")
	private int sustatusId;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="sustatus")
	private String sustatus;
	
	@Column(name="phone")
	private String phone;

	public int getSustatusId() {
		return sustatusId;
	}

	public void setSustatusId(int sustatusId) {
		this.sustatusId = sustatusId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSustatus() {
		return sustatus;
	}

	public void setSustatus(String sustatus) {
		this.sustatus = sustatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
