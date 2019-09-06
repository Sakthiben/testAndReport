package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stkrepproject001mb")
public class StkRepProjected001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stprojId")
	private int stprojId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="brand")
	private String brand;
	
	
	@Column(name="wareHouse")
	private String wareHouse;
	
	@Column(name="UOM")
	private String UOM;
	
	@Column(name="actualQty")
	private String actualQty;
	
	@Column(name="plannedQty")
	private String plannedQty;
	
	@Column(name="requestedQty")
	private String requestedQty;
	
	@Column(name="orderedQty")
	private String orderedQty;
	
	@Column(name="reservedQty")
	private String reservedQty;
	
	@Column(name="reorderValue")
	private String reorderValue;
	
	@Column(name="reorderQty")
	private String reorderQty;
	
	@Column(name="shortageQty")
	private String shortageQty;

	public int getStprojId() {
		return stprojId;
	}

	public void setStprojId(int stprojId) {
		this.stprojId = stprojId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getActualQty() {
		return actualQty;
	}

	public void setActualQty(String actualQty) {
		this.actualQty = actualQty;
	}

	public String getPlannedQty() {
		return plannedQty;
	}

	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}

	public String getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(String requestedQty) {
		this.requestedQty = requestedQty;
	}

	public String getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(String orderedQty) {
		this.orderedQty = orderedQty;
	}

	public String getReservedQty() {
		return reservedQty;
	}

	public void setReservedQty(String reservedQty) {
		this.reservedQty = reservedQty;
	}

	public String getReorderValue() {
		return reorderValue;
	}

	public void setReorderValue(String reorderValue) {
		this.reorderValue = reorderValue;
	}

	public String getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(String reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getShortageQty() {
		return shortageQty;
	}

	public void setShortageQty(String shortageQty) {
		this.shortageQty = shortageQty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
