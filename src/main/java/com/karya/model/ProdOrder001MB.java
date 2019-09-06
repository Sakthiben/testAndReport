package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodorder001mb")

public class ProdOrder001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prId")
	private int prId;
	
	@Column(name="itemtoManufacture")
	private String itemtoManufacture;
	
	@Column(name="status")
	private String status;
	
	@Column(name="prorderCode")
	private String prorderCode;

	public int getPrId() {
		return prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public String getItemtoManufacture() {
		return itemtoManufacture;
	}

	public void setItemtoManufacture(String itemtoManufacture) {
		this.itemtoManufacture = itemtoManufacture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProrderCode() {
		return prorderCode;
	}

	public void setProrderCode(String prorderCode) {
		this.prorderCode = prorderCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
