package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stkrepledger001mb")
public class StkRepLedger001MB implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stledId")
	private int stledId;
	
	@Column(name="date")
	private String date;
	
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
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="balanceQty")
	private String balanceQty;
	
	@Column(name="incomingRate")
	private String incomingRate;
	
	@Column(name="valuationRate")
	private String valuationRate;
	
	@Column(name="balanceValue")
	private String balanceValue;
	
	@Column(name="voucherType")
	private String voucherType;
	
	@Column(name="voucherCode")
	private String voucherCode;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="serialNo")
	private String serialNo;
	
	@Column(name="company")
	private String company;

	public int getStledId() {
		return stledId;
	}

	public void setStledId(int stledId) {
		this.stledId = stledId;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBalanceQty() {
		return balanceQty;
	}

	public void setBalanceQty(String balanceQty) {
		this.balanceQty = balanceQty;
	}

	public String getIncomingRate() {
		return incomingRate;
	}

	public void setIncomingRate(String incomingRate) {
		this.incomingRate = incomingRate;
	}

	public String getValuationRate() {
		return valuationRate;
	}

	public void setValuationRate(String valuationRate) {
		this.valuationRate = valuationRate;
	}

	public String getBalanceValue() {
		return balanceValue;
	}

	public void setBalanceValue(String balanceValue) {
		this.balanceValue = balanceValue;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
