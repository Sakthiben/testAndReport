package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufactureset001mb")
public class ManufactureSetup001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mansetId")
	private int mansetId;
	
	@Column(name="disableCPandTT")
	private boolean disableCPandTT;
	
	@Column(name="allowOT")
	private boolean allowOT;
	
	@Column(name="allowProdinholy")
	private boolean allowProdinholy;
	
	@Column(name="prodPercent")
	private String prodPercent;
	
	@Column(name="backflushRM")
	private String backflushRM;
	
	@Column(name="capacityPlan")
	private String capacityPlan;
	
	@Column(name="timebwOpern")
	private String timebwOpern;
	
	@Column(name="defworkinProgWH")
	private String defworkinProgWH;
	
	@Column(name="defFingoodsWH")
	private String defFingoodsWH;

	public int getMansetId() {
		return mansetId;
	}

	public void setMansetId(int mansetId) {
		this.mansetId = mansetId;
	}

	public boolean isDisableCPandTT() {
		return disableCPandTT;
	}

	public void setDisableCPandTT(boolean disableCPandTT) {
		this.disableCPandTT = disableCPandTT;
	}

	

	public boolean isAllowOT() {
		return allowOT;
	}

	public void setAllowOT(boolean allowOT) {
		this.allowOT = allowOT;
	}

	

	public boolean isAllowProdinholy() {
		return allowProdinholy;
	}

	public void setAllowProdinholy(boolean allowProdinholy) {
		this.allowProdinholy = allowProdinholy;
	}

	public String getProdPercent() {
		return prodPercent;
	}

	public void setProdPercent(String prodPercent) {
		this.prodPercent = prodPercent;
	}

	public String getBackflushRM() {
		return backflushRM;
	}

	public void setBackflushRM(String backflushRM) {
		this.backflushRM = backflushRM;
	}

	public String getCapacityPlan() {
		return capacityPlan;
	}

	public void setCapacityPlan(String capacityPlan) {
		this.capacityPlan = capacityPlan;
	}

	public String getTimebwOpern() {
		return timebwOpern;
	}

	public void setTimebwOpern(String timebwOpern) {
		this.timebwOpern = timebwOpern;
	}

	public String getDefworkinProgWH() {
		return defworkinProgWH;
	}

	public void setDefworkinProgWH(String defworkinProgWH) {
		this.defworkinProgWH = defworkinProgWH;
	}

	public String getDefFingoodsWH() {
		return defFingoodsWH;
	}

	public void setDefFingoodsWH(String defFingoodsWH) {
		this.defFingoodsWH = defFingoodsWH;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
