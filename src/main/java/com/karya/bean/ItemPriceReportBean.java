package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemPriceReportBean {
	
	private int itpricesId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item group")
	private String itemGroup;
	
	@NotNull
	 @NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	 @NotEmpty(message = "Please enter the UOM")
	private String UOM;
	
	@NotNull
	 @NotEmpty(message = "Please enter the ladt purchase")
	private String lstPurchase;
	
	@NotNull
	 @NotEmpty(message = "Please enter the valuation rate")
	private String valuationRate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the sales price list")
	private String spList;
	
	@NotNull
	 @NotEmpty(message = "Please enter the purchase price list")
	private String ppList;
	
	@NotNull
	 @NotEmpty(message = "Please enter the bomrate")
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
	
	
	
	

}
