package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="orditemsdeliver001mb")
public class OrderItemsDelivered001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "orditemsId")
	private int orditemsId;
	
	@Column(name="sorderName")
	private String sorderName;
	
	@Column(name="customername")
	private String customername;
	
	@Column(name="date")
	private String date;
	
	@Column(name="projectName")
	private String projectName;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="deliverQty")
	private String deliverQty;
	
	@Column(name="qtytoDeliver")
	private String qtytoDeliver;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="amttoDeliver")
	private String amttoDeliver;
	
	@Column(name="availableQty")
	private String availableQty;
	
	@Column(name="projectedQty")
	private String projectedQty;
	
	@Column(name="expectedQty")
	private String expectedQty;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="warehouseName")
	private String warehouseName;

	public int getOrditemsId() {
		return orditemsId;
	}

	public void setOrditemsId(int orditemsId) {
		this.orditemsId = orditemsId;
	}

	public String getSorderName() {
		return sorderName;
	}

	public void setSorderName(String sorderName) {
		this.sorderName = sorderName;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDeliverQty() {
		return deliverQty;
	}

	public void setDeliverQty(String deliverQty) {
		this.deliverQty = deliverQty;
	}

	public String getQtytoDeliver() {
		return qtytoDeliver;
	}

	public void setQtytoDeliver(String qtytoDeliver) {
		this.qtytoDeliver = qtytoDeliver;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmttoDeliver() {
		return amttoDeliver;
	}

	public void setAmttoDeliver(String amttoDeliver) {
		this.amttoDeliver = amttoDeliver;
	}

	public String getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}

	public String getProjectedQty() {
		return projectedQty;
	}

	public void setProjectedQty(String projectedQty) {
		this.projectedQty = projectedQty;
	}

	public String getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(String expectedQty) {
		this.expectedQty = expectedQty;
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

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
