package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodbundle001mb")
public class ProductBundle001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pbundId")
	private int pbundId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="childItem")
	private String childItem;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="description")
	private String description;

	public int getPbundId() {
		return pbundId;
	}

	public void setPbundId(int pbundId) {
		this.pbundId = pbundId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getChildItem() {
		return childItem;
	}

	public void setChildItem(String childItem) {
		this.childItem = childItem;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
