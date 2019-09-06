package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stktransdeliver001mb")
public class StockTransDelivery001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stdelId")
	private int stdelId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="status")
	private String status;
	
	@Column(name="grandTotal")
	private String grandTotal;
	
	@Column(name="delName")
	private String delName;

	public int getStdelId() {
		return stdelId;
	}

	public void setStdelId(int stdelId) {
		this.stdelId = stdelId;
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

	public String getDelName() {
		return delName;
	}

	public void setDelName(String delName) {
		this.delName = delName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
