package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="itemdt001mb")
public class Itemdt001MB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="itemid")
	private int itemId;
	
	@Column(name="Itemcode")
	private String itemCode;
	
	
	@Column(name="Quantity")
	private Integer quantity;
	
	@Column(name="Rate")
	private String rate;
	
	@Column(name="Amount")
	private String amount;
	
	
	@OneToMany(mappedBy="itemdt001MB")
	private Set<SalesOrder001MB> salesOrder001MB;


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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


	public Set<SalesOrder001MB> getSalesOrder001MB() {
		return salesOrder001MB;
	}


	public void setSalesOrder001MB(Set<SalesOrder001MB> salesOrder001MB) {
		this.salesOrder001MB = salesOrder001MB;
	}
	
}