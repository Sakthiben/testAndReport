package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employmenttype001mb")
public class EmploymentType001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "etypeId")
	private int etypeId;
	
	@Column(name="employmentType")
	private String employmentType;

	public int getEtypeId() {
		return etypeId;
	}

	public void setEtypeId(int etypeId) {
		this.etypeId = etypeId;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
