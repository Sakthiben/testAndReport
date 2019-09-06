package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodplan001mb")

public class ProdPlanning001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prplanId")
	private int prplanId;
	
	@Column(name="getItems")
	private String getItems;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="bomNo")
	private String bomNo;
	
	@Column(name="plannedQty")
	private String plannedQty;
	
	@Column(name="pendingQty")
	private String pendingQty;
	
	@Column(name="description")
	private String description;

	public int getPrplanId() {
		return prplanId;
	}

	public void setPrplanId(int prplanId) {
		this.prplanId = prplanId;
	}

	public String getGetItems() {
		return getItems;
	}

	public void setGetItems(String getItems) {
		this.getItems = getItems;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getBomNo() {
		return bomNo;
	}

	public void setBomNo(String bomNo) {
		this.bomNo = bomNo;
	}

	public String getPlannedQty() {
		return plannedQty;
	}

	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}

	public String getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(String pendingQty) {
		this.pendingQty = pendingQty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
