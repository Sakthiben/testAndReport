package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crmmintoresp001mb")
public class CrmMinTimeResp001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mrpId")
	private int mrpId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="mintoresp")
	private String mintoresp;

	public int getMrpId() {
		return mrpId;
	}

	public void setMrpId(int mrpId) {
		this.mrpId = mrpId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMintoresp() {
		return mintoresp;
	}

	public void setMintoresp(String mintoresp) {
		this.mintoresp = mintoresp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
