package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxrule001mb")
public class TaxRule001MB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="taxtype")
	private String taxtype;
	
	@Column(name="taxtemplate")
	private String taxtemplate;
	
	@Column(name="customer")
	private String customer;
	
	@Column(name="billingcity")
	private String billingcity;
	
	@Column(name="shippingcity")
	private String shippingcity;
	
	@Column(name="billingstate")
	private String billingstate;
	
	@Column(name="shippingstate")
	private String shippingstate;
	
	@Column(name="billingcountry")
	private String billingcountry;
	
	@Column(name="shippingcountry")
	private String shippingcountry;
	
	@Column(name="fromdate")
	private String fromdate;
	
	@Column(name="todate")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
