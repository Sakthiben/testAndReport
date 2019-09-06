package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemshortagerep001mb")
public class ItemShortageReport001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "shrepid")
	private int shrepid;
	
	@Column(name="warehouseName")
	private String warehouseName;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="actualQty")
	private String actualQty;
	
	@Column(name="orderedQty")
	private String orderedQty;
	
	public int getShrepid() {
		return shrepid;
	}

	public void setShrepid(int shrepid) {
		this.shrepid = shrepid;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getActualQty() {
		return actualQty;
	}

	public void setActualQty(String actualQty) {
		this.actualQty = actualQty;
	}

	public String getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}

	public String getPlannedQty() {
		return plannedQty;
	}

	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}

	public String getReservedQty() {
		return reservedQty;
	}

	public void setReservedQty(String reservedQty) {
		this.reservedQty = reservedQty;
	}

	public String getProjectedQty() {
		return projectedQty;
	}

	public void setProjectedQty(String projectedQty) {
		this.projectedQty = projectedQty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name="plannedQty")
	private String plannedQty;
	
	@Column(name="reservedQty")
	private String reservedQty;
	
	@Column(name="projectedQty")
	private String projectedQty;
	
	
	

}
