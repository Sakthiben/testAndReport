package com.karya.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockentry001mb")
public class StockEntry001MB implements Serializable {
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="stockid")
	private int stockid;
	
	@Column(name="materialrequest")
	private String  materialrequest;
	
	@Column(name="date")
	private String  date;
	
	@Column(name="Quantity")
	private int Quantity;
	
	@Column(name="TransferedQty")
	private Double TransferedQty;
	
	@Column(name="Qtytotransfer")
	private Double Qtytotransfer;
	
	@Column(name="description")
	private String description;
	
	@Column(name="Company")
	private  String  Company;
	
	@Column(name="itemid")
	private  int  itemid;

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public String getMaterialrequest() {
		return materialrequest;
	}

	public void setMaterialrequest(String materialrequest) {
		this.materialrequest = materialrequest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTransferedQty() {
		return TransferedQty;
	}

	public void setTransferedQty(Double transferedQty) {
		TransferedQty = transferedQty;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Double getQtytotransfer() {
		return Qtytotransfer;
	}

	public void setQtytotransfer(Double qtytotransfer) {
		Qtytotransfer = qtytotransfer;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	
}