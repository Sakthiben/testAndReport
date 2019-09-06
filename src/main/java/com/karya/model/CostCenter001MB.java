package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="costcenter001mb")
public class CostCenter001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "centId")
	private int centId;
	
	@Column(name="centerName")
	private String centerName;

	public int getCentId() {
		return centId;
	}

	public void setCentId(int centId) {
		this.centId = centId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
