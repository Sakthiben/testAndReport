package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itempricereport001mb")
public class ItemPriceReport001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "itpricesId")
	private int itpricesId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="description")
	private String description;
	
	@Column(name="UOM")
	private String UOM;
	
	
	@Column(name="lstPurchase")
	private String lstPurchase;
	
	@Column(name="valuationRate")
	private String valuationRate;
	
	@Column(name="spList")
	private String spList;
	
	@Column(name="ppList")
	private String ppList;
	
	@Column(name="bomRate")
	private String bomRate;

	public int getItpricesId() {
		return itpricesId;
	}

	public void setItpricesId(int itpricesId) {
		this.itpricesId = itpricesId;
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

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public String getLstPurchase() {
		return lstPurchase;
	}

	public void setLstPurchase(String lstPurchase) {
		this.lstPurchase = lstPurchase;
	}

	public String getValuationRate() {
		return valuationRate;
	}

	public void setValuationRate(String valuationRate) {
		this.valuationRate = valuationRate;
	}

	public String getSpList() {
		return spList;
	}

	public void setSpList(String spList) {
		this.spList = spList;
	}

	public String getPpList() {
		return ppList;
	}

	public void setPpList(String ppList) {
		this.ppList = ppList;
	}

	public String getBomRate() {
		return bomRate;
	}

	public void setBomRate(String bomRate) {
		this.bomRate = bomRate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
