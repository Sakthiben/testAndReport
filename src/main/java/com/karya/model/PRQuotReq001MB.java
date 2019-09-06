package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prreqquot001mb")
public class PRQuotReq001MB implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prqId")
	private int prqId;
	
	@Column(name="rqSeries")
	private String rqSeries;
	
	@Column(name="date")
	private String date;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="requiredDate")
	private String requiredDate;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="warehouse")
	private String warehouse;

	public int getPrqId() {
		return prqId;
	}

	public void setPrqId(int prqId) {
		this.prqId = prqId;
	}

	public String getRqSeries() {
		return rqSeries;
	}

	public void setRqSeries(String rqSeries) {
		this.rqSeries = rqSeries;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
