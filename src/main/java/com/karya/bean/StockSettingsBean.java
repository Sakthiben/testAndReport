package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StockSettingsBean {

	private int setId;
	
	@NotNull
	@NotEmpty(message = "Please enter the item name source")
	private String itemnameBy;
	
	@NotNull
	 @NotEmpty(message = "Please enter the default valuation method")
	private String defaultValue;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item group")
	private String itemGroup;
	
	@NotNull
	 @NotEmpty(message = "Please enter the percent")
	private String allowancePercent;
	
	@NotNull
	 @NotEmpty(message = "Please mention UOM")
	private String defaultUOM;
	
	@NotNull
	 @NotEmpty(message = "Please enter the warehouse name")
	private String warehouseName;
	
	
	private boolean showbarcodeField;
	private boolean autoinsertPricelist;
	private boolean autosetSerialno;
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
	
	
	
}
