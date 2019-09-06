package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stksettings001mb")
public class StockSettings001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "setId")
	private int setId;
	
	@Column(name="itemnameBy")
	private String itemnameBy;
	
	@Column(name="defaultValue")
	private String defaultValue;
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="allowancePercent")
	private String allowancePercent;
	
	@Column(name="defaultUOM")
	private String defaultUOM;
	
	@Column(name="warehouseName")
	private String warehouseName;
	
	@Column(name="showbarcodeField")
	private boolean showbarcodeField;
	
	@Column(name="autoinsertPricelist")
	private boolean autoinsertPricelist;

	
	@Column(name="autosetSerialno")
	private boolean autosetSerialno;

	
	@Column(name="allownegativeStock")
	private boolean allownegativeStock;


	public int getSetId() {
		return setId;
	}


	public void setSetId(int setId) {
		this.setId = setId;
	}


	public String getItemnameBy() {
		return itemnameBy;
	}


	public void setItemnameBy(String itemnameBy) {
		this.itemnameBy = itemnameBy;
	}


	public String getDefaultValue() {
		return defaultValue;
	}


	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}


	public String getItemGroup() {
		return itemGroup;
	}


	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}


	public String getAllowancePercent() {
		return allowancePercent;
	}


	public void setAllowancePercent(String allowancePercent) {
		this.allowancePercent = allowancePercent;
	}


	public String getDefaultUOM() {
		return defaultUOM;
	}


	public void setDefaultUOM(String defaultUOM) {
		this.defaultUOM = defaultUOM;
	}


	public String getWarehouseName() {
		return warehouseName;
	}


	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}


	public boolean isShowbarcodeField() {
		return showbarcodeField;
	}


	public void setShowbarcodeField(boolean showbarcodeField) {
		this.showbarcodeField = showbarcodeField;
	}


	public boolean isAutoinsertPricelist() {
		return autoinsertPricelist;
	}


	public void setAutoinsertPricelist(boolean autoinsertPricelist) {
		this.autoinsertPricelist = autoinsertPricelist;
	}


	public boolean isAutosetSerialno() {
		return autosetSerialno;
	}


	public void setAutosetSerialno(boolean autosetSerialno) {
		this.autosetSerialno = autosetSerialno;
	}


	public boolean isAllownegativeStock() {
		return allownegativeStock;
	}


	public void setAllownegativeStock(boolean allownegativeStock) {
		this.allownegativeStock = allownegativeStock;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}
