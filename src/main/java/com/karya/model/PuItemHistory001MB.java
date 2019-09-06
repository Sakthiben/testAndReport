package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itempuhist001mb")
public class PuItemHistory001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "histId")
	private int histId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="date")
	private String date;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="poSeries")
	private String poSeries;
	
	
	
	@Column(name="transDate")
	private String transDate;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="receivedQty")
	private String receivedQty;
	
	@Column(name="company")
	private String company;

	public int getHistId() {
		return histId;
	}

	public void setHistId(int histId) {
		this.histId = histId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPoSeries() {
		return poSeries;
	}

	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
