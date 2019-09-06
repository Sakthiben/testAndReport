package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stktranspurecpt001mb")
public class StockTransPurRecpt001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stpurtId")
	private int stpurtId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="status")
	private String status;
	
	@Column(name="grandTotal")
	private String grandTotal;
	
	@Column(name="purtName")
	private String purtName;

	public int getStpurtId() {
		return stpurtId;
	}

	public void setStpurtId(int stpurtId) {
		this.stpurtId = stpurtId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPurtName() {
		return purtName;
	}

	public void setPurtName(String purtName) {
		this.purtName = purtName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
