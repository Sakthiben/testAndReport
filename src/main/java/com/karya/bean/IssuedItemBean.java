package com.karya.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class IssuedItemBean {
	
	private int issueId;
	 @NotNull
	 @NotEmpty(message = "Please select PROrder Code")
	private String porderCode;
	 @NotNull
	 @NotEmpty(message = "Please enter the issue date")
	private String issueDate;
	 @NotNull
	 @NotEmpty(message = "Please select the Item Issued")
	private String itemCode;
	 @NotNull
     @Size(min=2, max=200, message="Please enter description below 200 characters")
	private String description;
	 @NotNull
	 @NotEmpty(message = "Please enter the Quantity")
	private String quantity;
	 @NotNull
	 @NotEmpty(message = "Please enter the UOM")
	private String uom;
	 @NotNull
	 @NotEmpty(message = "Please enter the Amount")
	private String amount;
	 @NotNull
	 @NotEmpty(message = "Please enter the Serial Number")
	private String serialNo;
	 @NotNull
	 @NotEmpty(message = "Please enter the Serial WH")
	private String sourceWH;
	 @NotNull
	 @NotEmpty(message = "Please enter the Target WH")
	private String targetWH;
	 @NotNull
	 @NotEmpty(message = "Please enter the Stock Entry")
	private String stockEntry;
	 @NotNull
	 @NotEmpty(message = "Please enter the Company")
	private String company;
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getPorderCode() {
		return porderCode;
	}
	public void setPorderCode(String porderCode) {
		this.porderCode = porderCode;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSourceWH() {
		return sourceWH;
	}
	public void setSourceWH(String sourceWH) {
		this.sourceWH = sourceWH;
	}
	public String getTargetWH() {
		return targetWH;
	}
	public void setTargetWH(String targetWH) {
		this.targetWH = targetWH;
	}
	public String getStockEntry() {
		return stockEntry;
	}
	public void setStockEntry(String stockEntry) {
		this.stockEntry = stockEntry;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
