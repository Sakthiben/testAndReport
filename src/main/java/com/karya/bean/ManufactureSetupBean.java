package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ManufactureSetupBean {
	
	private int mansetId;
	private boolean disableCPandTT;
	private boolean allowOT;
	private boolean allowProdinholy;
	@NotNull
	@NotEmpty(message= "Please enter Production Percentage")
	private String prodPercent;
	@NotNull
	@NotEmpty(message= "Please enter BackFlush Raw Materials Based on")
	private String backflushRM;
	@NotNull
	@NotEmpty(message= "Please enter Capacity Planned")
	private String capacityPlan;
	@NotNull
	@NotEmpty(message= "Please enter Time Between Operation")
	private String timebwOpern;
	@NotNull
	@NotEmpty(message= "Please select Default Work in Progress")
	private String defworkinProgWH;
	@NotNull
	@NotEmpty(message= "Please select Default Finished Goods")
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
	
	

}
