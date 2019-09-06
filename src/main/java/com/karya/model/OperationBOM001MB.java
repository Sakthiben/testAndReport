package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operationbom001mb")

public class OperationBOM001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "opId")
	private int opId;
	
	@Column(name="opName")
	private String opName;
	
	@Column(name="workstName")
	private String workstName;

	public int getOpId() {
		return opId;
	}

	public void setOpId(int opId) {
		this.opId = opId;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
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
