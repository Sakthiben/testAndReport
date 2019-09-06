package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TaxRuleBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Tax type")
	private String taxtype;
	
	@NotNull
	@NotEmpty(message = "Please Enter Tax Template")
	private String taxtemplate;
	
	@NotNull
	@NotEmpty(message = "Please Select Customer")
	private String customer;
	
	@NotNull
	@NotEmpty(message = "Please Enter Billing City")
	private String billingcity;
	
	@NotNull
	@NotEmpty(message = "Please Enter Shipping City")
	private String shippingcity;
	
	@NotNull
	@NotEmpty(message = "Please Enter Billing State")
	private String billingstate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Shipping State")
	private String shippingstate;
	
	@NotNull
	@NotEmpty(message = "Please Enter Billing Country")
	private String billingcountry;
	
	@NotNull
	@NotEmpty(message = "Please Enter Shipping Country")
	private String shippingcountry;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String fromdate;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String todate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
	public String getTaxtemplate() {
		return taxtemplate;
	}
	public void setTaxtemplate(String taxtemplate) {
		this.taxtemplate = taxtemplate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getBillingcity() {
		return billingcity;
	}
	public void setBillingcity(String billingcity) {
		this.billingcity = billingcity;
	}
	public String getShippingcity() {
		return shippingcity;
	}
	public void setShippingcity(String shippingcity) {
		this.shippingcity = shippingcity;
	}
	public String getBillingstate() {
		return billingstate;
	}
	public void setBillingstate(String billingstate) {
		this.billingstate = billingstate;
	}
	public String getShippingstate() {
		return shippingstate;
	}
	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}
	public String getBillingcountry() {
		return billingcountry;
	}
	public void setBillingcountry(String billingcountry) {
		this.billingcountry = billingcountry;
	}
	public String getShippingcountry() {
		return shippingcountry;
	}
	public void setShippingcountry(String shippingcountry) {
		this.shippingcountry = shippingcountry;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
}
