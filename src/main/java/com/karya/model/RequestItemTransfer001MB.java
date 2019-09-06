package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reqitemtransfer001mb")
public class RequestItemTransfer001MB implements Serializable{

private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ittransId")
	private int ittransId;
	
	@Column(name="mrSeries")
	private String mrSeries;
	
	@Column(name="date")
	private String date;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="transferQty")
	private String transferQty;
	
	
	@Column(name="qtytoTransfer")
	private String qtytoTransfer;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="company")
	private String company;

	public int getIttransId() {
		return ittransId;
	}

	public void setIttransId(int ittransId) {
		this.ittransId = ittransId;
	}

	public String getMrSeries() {
		return mrSeries;
	}

	public void setMrSeries(String mrSeries) {
		this.mrSeries = mrSeries;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTransferQty() {
		return transferQty;
	}

	public void setTransferQty(String transferQty) {
		this.transferQty = transferQty;
	}

	public String getQtytoTransfer() {
		return qtytoTransfer;
	}

	public void setQtytoTransfer(String qtytoTransfer) {
		this.qtytoTransfer = qtytoTransfer;
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
