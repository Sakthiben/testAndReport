package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pricingrule001mb")
public class PricingRule001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "priceruleid")
	private int priceruleid;
	
	@Column(name="priceTitle")
	private String priceTitle;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="selling")
	private boolean selling;
	
	@Column(name="buying")
	private boolean buying;
	
	@Column(name="minQty")
	private String minQty;
	
	@Column(name="maxQty")
	private String maxQty;
	
	@Column(name="validFrom")
	private String validFrom;
	
	@Column(name="company")
	private String company;
	
	
	@Column(name="validUpto")
	private String validUpto;
	
	@Column(name="prordisc")
	private String prordisc;
	
	@Column(name="discprlist")
	private String discprlist;
	
	@Column(name="forprlist")
	private String forprlist;

	public int getPriceruleid() {
		return priceruleid;
	}

	public void setPriceruleid(int priceruleid) {
		this.priceruleid = priceruleid;
	}

	public String getPriceTitle() {
		return priceTitle;
	}

	public void setPriceTitle(String priceTitle) {
		this.priceTitle = priceTitle;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	

	public boolean isSelling() {
		return selling;
	}

	public void setSelling(boolean selling) {
		this.selling = selling;
	}

	public boolean isBuying() {
		return buying;
	}

	public void setBuying(boolean buying) {
		this.buying = buying;
	}

	public String getMinQty() {
		return minQty;
	}

	public void setMinQty(String minQty) {
		this.minQty = minQty;
	}

	public String getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(String maxQty) {
		this.maxQty = maxQty;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}

	public String getPrordisc() {
		return prordisc;
	}

	public void setPrordisc(String prordisc) {
		this.prordisc = prordisc;
	}

	public String getDiscprlist() {
		return discprlist;
	}

	public void setDiscprlist(String discprlist) {
		this.discprlist = discprlist;
	}

	public String getForprlist() {
		return forprlist;
	}

	public void setForprlist(String forprlist) {
		this.forprlist = forprlist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
