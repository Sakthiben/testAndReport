package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prpurchaseord001mb")
public class PRPurOrd001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "proId")
	private int proId;
	
	@Column(name="poSeries")
	private String poSeries;
	
	@Column(name="date")
	private String date;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="supplyrawmat")
	private String supplyrawmat;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="prtype")
	private String prtype;
	
	@Column(name="accountHead")
	private String accountHead;
	
	@Column(name="quotrate")
	private String quotrate;
	
	@Column(name="taxandChg")
	private String taxandChg;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getPoSeries() {
		return poSeries;
	}

	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
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

	public String getSupplyrawmat() {
		return supplyrawmat;
	}

	public void setSupplyrawmat(String supplyrawmat) {
		this.supplyrawmat = supplyrawmat;
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

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getQuotrate() {
		return quotrate;
	}

	public void setQuotrate(String quotrate) {
		this.quotrate = quotrate;
	}

	public String getTaxandChg() {
		return taxandChg;
	}

	public void setTaxandChg(String taxandChg) {
		this.taxandChg = taxandChg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
