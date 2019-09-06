package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch001mb")
public class Branch001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "branchId")
	private int branchId;
	
	@Column(name="branchName")
	private String branchName;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
