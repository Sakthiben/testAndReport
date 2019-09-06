package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier001mb")
public class Supplier001MB implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "supId")
	private int supId;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="addType")
	private String addType;
	
	@Column(name="supCity")
	private String supCity;
	
	@Column(name="supAddress")
	private String supAddress;
	
	@Column(name="supPhone")
	private String supPhone;
	
	@Column(name="supCountry")
	private String supCountry;
	
	@Column(name="supState")
	private String supState;

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	public String getSupCity() {
		return supCity;
	}

	public void setSupCity(String supCity) {
		this.supCity = supCity;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public String getSupPhone() {
		return supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupCountry() {
		return supCountry;
	}

	public void setSupCountry(String supCountry) {
		this.supCountry = supCountry;
	}

	public String getSupState() {
		return supState;
	}

	public void setSupState(String supState) {
		this.supState = supState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
