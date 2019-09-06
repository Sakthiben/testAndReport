package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AssetBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Asset Name.")
	private String asset;
	
	@NotNull
	@NotEmpty(message = "Please select Depreciation Date.")
	private String depreciationdate;
	
    @Min(value=1)
    @NotNull(message= "Please enter Purchase Amount")
	private int purchaseamount;
    
    @Min(value=1)
    @NotNull(message= "Please enter Depreciation Amount")
	private int depreciationamount;
    
    @Min(value=1)
    @NotNull(message= "Please enter Accumulated Depreciation Amount")
	private int accumulateddepreciationamount;
    
    @Min(value=1)
    @NotNull(message= "Please enter Amount After Depreciation")
	private int amountafterdepreciation;
    
    @NotNull
	@NotEmpty(message = "Please Enter Depreciation entry.")
	private String depreciationentry;
    
    @NotNull
	@NotEmpty(message = "Please Enter Asset Category.")
	private String assetcategory;
    
    @NotNull
	@NotEmpty(message = "Please Enter Current Status.")
	private String currentstatus;
    
    @NotNull
	@NotEmpty(message = "Please Enter Depreciation Method.")
	private String depreciationmethod;
    
    @NotNull
	@NotEmpty(message = "Please select Purchase Date.")
	private String purchasedate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getDepreciationdate() {
		return depreciationdate;
	}
	public void setDepreciationdate(String depreciationdate) {
		this.depreciationdate = depreciationdate;
	}
	public int getPurchaseamount() {
		return purchaseamount;
	}
	public void setPurchaseamount(int purchaseamount) {
		this.purchaseamount = purchaseamount;
	}
	public int getDepreciationamount() {
		return depreciationamount;
	}
	public void setDepreciationamount(int depreciationamount) {
		this.depreciationamount = depreciationamount;
	}
	public int getAccumulateddepreciationamount() {
		return accumulateddepreciationamount;
	}
	public void setAccumulateddepreciationamount(int accumulateddepreciationamount) {
		this.accumulateddepreciationamount = accumulateddepreciationamount;
	}
	public int getAmountafterdepreciation() {
		return amountafterdepreciation;
	}
	public void setAmountafterdepreciation(int amountafterdepreciation) {
		this.amountafterdepreciation = amountafterdepreciation;
	}
	public String getDepreciationentry() {
		return depreciationentry;
	}
	public void setDepreciationentry(String depreciationentry) {
		this.depreciationentry = depreciationentry;
	}
	public String getAssetcategory() {
		return assetcategory;
	}
	public void setAssetcategory(String assetcategory) {
		this.assetcategory = assetcategory;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public String getDepreciationmethod() {
		return depreciationmethod;
	}
	public void setDepreciationmethod(String depreciationmethod) {
		this.depreciationmethod = depreciationmethod;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	
}
