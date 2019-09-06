package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purorditemreceive001mb")
public class PurItemsOrderReceived001MB implements Serializable{

private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "poitrecId")
	private int poitrecId;
	
	@Column(name="puOrder")
	private String puOrder;
	
	@Column(name="date")
	private String date;
	
	@Column(name="reqbyDate")
	private String reqbyDate;
	
	@Column(name="supName")
	private String supName;
	
	@Column(name="projectName")
	private String projectName;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="receivedQty")
	private String receivedQty;
	
	@Column(name="qtytoReceive")
	private String qtytoReceive;
	
	@Column(name="warehouseName")
	private String warehouseName;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="company")
	private String company;

	public int getPoitrecId() {
		return poitrecId;
	}

	public void setPoitrecId(int poitrecId) {
		this.poitrecId = poitrecId;
	}

	public String getPuOrder() {
		return puOrder;
	}

	public void setPuOrder(String puOrder) {
		this.puOrder = puOrder;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReqbyDate() {
		return reqbyDate;
	}

	public void setReqbyDate(String reqbyDate) {
		this.reqbyDate = reqbyDate;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getQtytoReceive() {
		return qtytoReceive;
	}

	public void setQtytoReceive(String qtytoReceive) {
		this.qtytoReceive = qtytoReceive;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
