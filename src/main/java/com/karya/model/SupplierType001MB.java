package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supptype001mb")
public class SupplierType001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sutypeId")
	private int sutypeId;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="suType")
	private String suType;
	
	public int getSutypeId() {
		return sutypeId;
	}

	public void setSutypeId(int sutypeId) {
		this.sutypeId = sutypeId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	

	public String getSuType() {
		return suType;
	}

	public void setSuType(String suType) {
		this.suType = suType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
