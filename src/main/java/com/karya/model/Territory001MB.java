package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="territory001mb")
public class Territory001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "terId")
	private int terId;
	
	@Column(name="terName")
	private String terName;

	public int getTerId() {
		return terId;
	}

	public void setTerId(int terId) {
		this.terId = terId;
	}

	public String getTerName() {
		return terName;
	}

	public void setTerName(String terName) {
		this.terName = terName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
