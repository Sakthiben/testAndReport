package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issueditem001mb")
public class IssuedItem001MB {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "issueId")
	private int issueId;
	
	@Column(name="porderCode")
	private String porderCode;
	
	@Column(name="issueDate")
	private String issueDate;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="serialNo")
	private String serialNo;
	
	@Column(name="sourceWH")
	private String sourceWH;
	
	@Column(name="targetWH")
	private String targetWH;
	
	@Column(name="stockEntry")
	private String stockEntry;
	
	@Column(name="company")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
