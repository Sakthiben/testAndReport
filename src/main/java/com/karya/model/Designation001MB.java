package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designation001mb")
public class Designation001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "designId")
	private int designId;
	
	@Column(name="designation")
	private String designation;

	public int getDesignId() {
		return designId;
	}

	public void setDesignId(int designId) {
		this.designId = designId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
