package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reqitemorder001mb")
public class ReqItemOrdBuy001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mrsId")
	private int mrsId;
	
	@Column(name="mrSeries")
	private String mrSeries;
	
	@Column(name="date")
	private String date;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="description")
	private String description;
	
	@Column(name="company")
	private String company;
	
	@Column(name="orderedqty")
	private String orderedqty;
	
	@Column(name="qtytoorder")
	private String qtytoorder;

	public int getMrsId() {
		return mrsId;
	}

	public void setMrsId(int mrsId) {
		this.mrsId = mrsId;
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

	public String getOrderedqty() {
		return orderedqty;
	}

	public void setOrderedqty(String orderedqty) {
		this.orderedqty = orderedqty;
	}

	public String getQtytoorder() {
		return qtytoorder;
	}

	public void setQtytoorder(String qtytoorder) {
		this.qtytoorder = qtytoorder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
