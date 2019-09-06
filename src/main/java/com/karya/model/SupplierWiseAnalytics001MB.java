package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="swsanalytics001mb")

public class SupplierWiseAnalytics001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "swsId")
	private int swsId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="swsUOM")
	private String swsUOM;
	
	@Column(name="consQty")
	private String consQty;
	
	@Column(name="consAmt")
	private String consAmt;
	
	@Column(name="delQty")
	private String delQty;
	
	@Column(name="delAmt")
	private String delAmt;
	
	@Column(name="totalQty")
	private String totalQty;
	
	@Column(name="totalAmt")
	private String totalAmt;

	public int getSwsId() {
		return swsId;
	}

	public void setSwsId(int swsId) {
		this.swsId = swsId;
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

	public String getSwsUOM() {
		return swsUOM;
	}

	public void setSwsUOM(String swsUOM) {
		this.swsUOM = swsUOM;
	}

	public String getConsQty() {
		return consQty;
	}

	public void setConsQty(String consQty) {
		this.consQty = consQty;
	}

	public String getConsAmt() {
		return consAmt;
	}

	public void setConsAmt(String consAmt) {
		this.consAmt = consAmt;
	}

	public String getDelQty() {
		return delQty;
	}

	public void setDelQty(String delQty) {
		this.delQty = delQty;
	}

	public String getDelAmt() {
		return delAmt;
	}

	public void setDelAmt(String delAmt) {
		this.delAmt = delAmt;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
