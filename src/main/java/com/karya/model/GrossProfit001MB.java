package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grossprofit001mb")
public class GrossProfit001MB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="salesinvoice")
	private String salesinvoice;
	
	@Column(name="customer")
	private String customer;
	
	@Column(name="postingdate")
	private String postingdate;
	
	@Column(name="itemname")
	private String itemname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="warehouse")
	private String warehouse;
	
	@Column(name="project")
	private String project;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="averagesellingrate")
	private int averagesellingrate;
	
	@Column(name="averagebuyingrate")
	private int averagebuyingrate;
	
	@Column(name="sellingamount")
	private int sellingamount;
	
	@Column(name="buyingamount")
	private int buyingamount;
	
	@Column(name="grossprofit")
	private int grossprofit;
	
	@Column(name="grosspercentage")
	private int grosspercentage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesinvoice() {
		return salesinvoice;
	}

	public void setSalesinvoice(String salesinvoice) {
		this.salesinvoice = salesinvoice;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAveragesellingrate() {
		return averagesellingrate;
	}

	public void setAveragesellingrate(int averagesellingrate) {
		this.averagesellingrate = averagesellingrate;
	}

	public int getAveragebuyingrate() {
		return averagebuyingrate;
	}

	public void setAveragebuyingrate(int averagebuyingrate) {
		this.averagebuyingrate = averagebuyingrate;
	}

	public int getSellingamount() {
		return sellingamount;
	}

	public void setSellingamount(int sellingamount) {
		this.sellingamount = sellingamount;
	}

	public int getBuyingamount() {
		return buyingamount;
	}

	public void setBuyingamount(int buyingamount) {
		this.buyingamount = buyingamount;
	}

	public int getGrossprofit() {
		return grossprofit;
	}

	public void setGrossprofit(int grossprofit) {
		this.grossprofit = grossprofit;
	}

	public int getGrosspercentage() {
		return grosspercentage;
	}

	public void setGrosspercentage(int grosspercentage) {
		this.grosspercentage = grosspercentage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
