package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packingslip001mb")
public class PackingSlip001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "psId")
	private int psId;
	
	@Column(name="slipName")
	private String slipName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="delName")
	private String delName;

	public int getPsId() {
		return psId;
	}

	public void setPsId(int psId) {
		this.psId = psId;
	}

	public String getSlipName() {
		return slipName;
	}

	public void setSlipName(String slipName) {
		this.slipName = slipName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelName() {
		return delName;
	}

	public void setDelName(String delName) {
		this.delName = delName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
