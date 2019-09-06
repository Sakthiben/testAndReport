package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prmatreq001mb")
public class PRMatReq001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pmrId")
	private int pmrId;
	
	@Column(name="mrType")
	private String mrType;
	
	@Column(name="mrSeries")
	private String mrSeries;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="forWarehouse")
	private String forWarehouse;
	
	@Column(name="requiredDate")
	private String requiredDate;

	public int getPmrId() {
		return pmrId;
	}

	public void setPmrId(int pmrId) {
		this.pmrId = pmrId;
	}

	public String getMrType() {
		return mrType;
	}

	public void setMrType(String mrType) {
		this.mrType = mrType;
	}

	public String getMrSeries() {
		return mrSeries;
	}

	public void setMrSeries(String mrSeries) {
		this.mrSeries = mrSeries;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getForWarehouse() {
		return forWarehouse;
	}

	public void setForWarehouse(String forWarehouse) {
		this.forWarehouse = forWarehouse;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
