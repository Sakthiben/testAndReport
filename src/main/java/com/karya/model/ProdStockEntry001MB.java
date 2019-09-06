package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodstockentry001mb")

public class ProdStockEntry001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prstockId")
	private int prstockId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="status")
	private String status;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="stockEntry")
	private String stockEntry;

	public int getPrstockId() {
		return prstockId;
	}

	public void setPrstockId(int prstockId) {
		this.prstockId = prstockId;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStockEntry() {
		return stockEntry;
	}

	public void setStockEntry(String stockEntry) {
		this.stockEntry = stockEntry;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
