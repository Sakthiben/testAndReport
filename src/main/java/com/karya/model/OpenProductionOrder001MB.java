package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="openprodorder001mb")
public class OpenProductionOrder001MB {
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prodId")
	private int prodId;
	
	@Column(name="prorderCode")
	private String prorderCode;
	
	@Column(name="date")
	private String date;
	
	@Column(name="itemtoManufacture")
	private String itemtoManufacture;
	
	@Column(name="toProduce")
	private String toProduce;
	
	@Column(name="produced")
	private String produced;
	
	@Column(name="empCompany")
	private String empCompany;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProrderCode() {
		return prorderCode;
	}

	public void setProrderCode(String prorderCode) {
		this.prorderCode = prorderCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getItemtoManufacture() {
		return itemtoManufacture;
	}

	public void setItemtoManufacture(String itemtoManufacture) {
		this.itemtoManufacture = itemtoManufacture;
	}

	public String getToProduce() {
		return toProduce;
	}

	public void setToProduce(String toProduce) {
		this.toProduce = toProduce;
	}

	public String getProduced() {
		return produced;
	}

	public void setProduced(String produced) {
		this.produced = produced;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
