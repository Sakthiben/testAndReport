package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class GrossProfitBean {
	
	private int id;
	 @NotNull
	 @NotEmpty(message = "Please enter salesinvoice")
	private String salesinvoice;
	 @NotNull
	 @NotEmpty(message = "Please select customer name")
	private String customer;
	 @NotNull
	 @NotEmpty(message = "Please enter date")
	private String postingdate;
	 @NotNull
	 @NotEmpty(message = "Please select item name")
	private String itemname;
	 @NotNull
	 @NotEmpty(message = "Please enter description")
	private String Description;
	 @NotNull
	 @NotEmpty(message = "Please enter warehouse")
	private String warehouse;
	 @NotNull
	 @NotEmpty(message = "Please enter project")
	private String project;
	 @NotNull
	 @NotEmpty(message = "Please enter currency")
	private String currency;
	 @NotNull
	 @Min(1)
	private int quantity;
	 @NotNull
	 @Min(1)
	private int averagesellingrate;
	 @NotNull
	 @Min(1)
	private int averagebuyingrate;
	 @NotNull
	 @Min(1)
	private int sellingamount;
	 @NotNull
	 @Min(1)
	private int buyingamount;
	 @NotNull
	 @Min(1)
	private int grossprofit;
	 @NotNull
	 @Min(1)
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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

}
