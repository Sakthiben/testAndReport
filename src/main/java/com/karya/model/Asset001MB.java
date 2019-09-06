package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset001mb")
public class Asset001MB {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="asset")
	private String asset;
	
	@Column(name="depreciationdate")
	private String depreciationdate;
	
	@Column(name="purchaseamount")
	private int purchaseamount;
	
	@Column(name="depreciationamount")
	private int depreciationamount;
	
	@Column(name="accumulateddepreciationamount")
	private int accumulateddepreciationamount;
	
	@Column(name="amountafterdepreciation")
	private int amountafterdepreciation;
	
	@Column(name="depreciationentry")
	private String depreciationentry;
	
	@Column(name="assetcategory")
	private String assetcategory;
	
	@Column(name="currentstatus")
	private String currentstatus;
	
	@Column(name="depreciationmethod")
	private String depreciationmethod;
	
	@Column(name="purchasedate")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
