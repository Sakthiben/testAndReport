package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purtaxcharges001mb")
public class PurchaseTaxChargeTemplate001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "putaxId")
	private int putaxId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="company")
	private String company;
	
	@Column(name="taxchgType")
	private String taxchgType;
	
	@Column(name="accountHead")
	private String accountHead;
	
	@Column(name="rate")
	private String rate;
	
		
	@Column(name="amount")
	private String amount;
	
	@Column(name="total")
	private String total;

	public int getPutaxId() {
		return putaxId;
	}

	public void setPutaxId(int putaxId) {
		this.putaxId = putaxId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTaxchgType() {
		return taxchgType;
	}

	public void setTaxchgType(String taxchgType) {
		this.taxchgType = taxchgType;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
