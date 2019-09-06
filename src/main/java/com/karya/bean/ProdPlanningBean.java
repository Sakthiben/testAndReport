package com.karya.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProdPlanningBean {
	
	private int prplanId;
	 @NotNull
	 @NotEmpty(message = "Please select Get Items From")
	private String getItems;
	 @NotNull
	 @NotEmpty(message = "Please select Item code")
	private String itemCode;
	 @NotNull
	 @NotEmpty(message = "Please enter BOM number")
	private String bomNo;
	 @NotNull
	 @NotEmpty(message = "Please enter Planned Quantity")
	private String plannedQty;
	 @NotNull
	 @NotEmpty(message = "Please enter Pending Quantity")
	private String pendingQty;
	 @NotNull
     @Size(min=2, max=200, message="Please enter description below 200 characters") 
	private String description;
	public int getPrplanId() {
		return prplanId;
	}
	public void setPrplanId(int prplanId) {
		this.prplanId = prplanId;
	}
	public String getGetItems() {
		return getItems;
	}
	public void setGetItems(String getItems) {
		this.getItems = getItems;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getBomNo() {
		return bomNo;
	}
	public void setBomNo(String bomNo) {
		this.bomNo = bomNo;
	}
	public String getPlannedQty() {
		return plannedQty;
	}
	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}
	public String getPendingQty() {
		return pendingQty;
	}
	public void setPendingQty(String pendingQty) {
		this.pendingQty = pendingQty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
