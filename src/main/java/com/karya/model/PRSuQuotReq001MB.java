package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prsureq001mb")
public class PRSuQuotReq001MB implements Serializable {
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prsrId")
	private int prsrId;
	
	@Column(name="suSeries")
	private String suSeries;
	
	@Column(name="date")
	private String date;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="stockUOM")
	private String stockUOM;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="taxandChg")
	private String taxandChg;
	
	@Column(name="accountHead")
	private String accountHead;
	
	@Column(name="squotrate")
	private String squotrate;
	
	@Column(name="sutype")
	private String sutype;

	public int getPrsrId() {
		return prsrId;
	}

	public void setPrsrId(int prsrId) {
		this.prsrId = prsrId;
	}

	public String getSuSeries() {
		return suSeries;
	}

	public void setSuSeries(String suSeries) {
		this.suSeries = suSeries;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public String getStockUOM() {
		return stockUOM;
	}

	public void setStockUOM(String stockUOM) {
		this.stockUOM = stockUOM;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTaxandChg() {
		return taxandChg;
	}

	public void setTaxandChg(String taxandChg) {
		this.taxandChg = taxandChg;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getSquotrate() {
		return squotrate;
	}

	public void setSquotrate(String squotrate) {
		this.squotrate = squotrate;
	}

	public String getSutype() {
		return sutype;
	}

	public void setSutype(String sutype) {
		this.sutype = sutype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
