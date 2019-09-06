package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salarycomponent001mb")
public class SalaryCompo001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "salcompId")
	private int salcompId;
	
	@Column(name="comName")
	private String comName;
	
	@Column(name="abbr")
	private String abbr;

	public int getSalcompId() {
		return salcompId;
	}

	public void setSalcompId(int salcompId) {
		this.salcompId = salcompId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
