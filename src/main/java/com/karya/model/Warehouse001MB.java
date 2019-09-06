package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse001mb")
public class Warehouse001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "whId")
	private int whId;
	
	@Column(name="warehouseName")
	private String warehouseName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="isActive")
	private String isActive;
	
	@Column(name="warehouseCode")
	private String warehouseCode;

	public int getWhId() {
		return whId;
	}

	public void setWhId(int whId) {
		this.whId = whId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
