package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemst001mb")

public class ItemStatus001MB implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "itemstId")
	private int itemstId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="status")
	private String status;
	
	@Column(name="itemGroup")
	private String itemGroup;

	public int getItemstId() {
		return itemstId;
	}

	public void setItemstId(int itemstId) {
		this.itemstId = itemstId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
