package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workstation001mb")

public class WorkStation001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "workstId")
	private int workstId;
	
	@Column(name="workstName")
	private String workstName;

	public int getWorkstId() {
		return workstId;
	}

	public void setWorkstId(int workstId) {
		this.workstId = workstId;
	}

	public String getWorkstName() {
		return workstName;
	}

	public void setWorkstName(String workstName) {
		this.workstName = workstName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
