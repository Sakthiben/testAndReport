package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stktransentry001mb")
public class StockTransEntry001MB implements Serializable{

private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stentid")
	private int stentid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="status")
	private String status;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="stName")
	private String stName;

	public int getStentid() {
		return stentid;
	}

	public void setStentid(int stentid) {
		this.stentid = stentid;
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

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
