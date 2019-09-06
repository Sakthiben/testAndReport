package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stkrepbalance001mb")
public class StockRepBalance001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stbalId")
	private int stbalId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="description")
	private String description;
	
	@Column(name="wareHouse")
	private String wareHouse;
	
	@Column(name="stkUOM")
	private String stkUOM;
	
	@Column(name="openingQty")
	private String openingQty;
	
	@Column(name="openingValue")
	private String openingValue;
	
	@Column(name="inQty")
	private String inQty;
	
	@Column(name="outQty")
	private String outQty;
	
	@Column(name="outValue")
	private String outValue;
	
	@Column(name="balanceQty")
	private String balanceQty;
	
	@Column(name="balanceValue")
	private String balanceValue;
	
	@Column(name="valuationRate")
	private String valuationRate;
	
	@Column(name="company")
	private String company;

	public int getStbalId() {
		return stbalId;
	}

	public void setStbalId(int stbalId) {
		this.stbalId = stbalId;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

	public String getStkUOM() {
		return stkUOM;
	}

	public void setStkUOM(String stkUOM) {
		this.stkUOM = stkUOM;
	}

	public String getOpeningQty() {
		return openingQty;
	}

	public void setOpeningQty(String openingQty) {
		this.openingQty = openingQty;
	}

	public String getOpeningValue() {
		return openingValue;
	}

	public void setOpeningValue(String openingValue) {
		this.openingValue = openingValue;
	}

	public String getInQty() {
		return inQty;
	}

	public void setInQty(String inQty) {
		this.inQty = inQty;
	}

	public String getOutQty() {
		return outQty;
	}

	public void setOutQty(String outQty) {
		this.outQty = outQty;
	}

	public String getOutValue() {
		return outValue;
	}

	public void setOutValue(String outValue) {
		this.outValue = outValue;
	}

	public String getBalanceQty() {
		return balanceQty;
	}

	public void setBalanceQty(String balanceQty) {
		this.balanceQty = balanceQty;
	}

	public String getBalanceValue() {
		return balanceValue;
	}

	public void setBalanceValue(String balanceValue) {
		this.balanceValue = balanceValue;
	}

	public String getValuationRate() {
		return valuationRate;
	}

	public void setValuationRate(String valuationRate) {
		this.valuationRate = valuationRate;
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
