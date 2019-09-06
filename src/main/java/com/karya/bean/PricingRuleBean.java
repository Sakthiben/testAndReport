package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;
public class PricingRuleBean {
	private int priceruleid;
	@NotNull
	 @NotEmpty(message = "Please enter priceTitle")
	private String priceTitle;
	@NotNull
	@NotEmpty(message = "Please select itemCode")
	private String itemCode;
	private boolean selling;
	private boolean buying;
	@NotNull
	@NotEmpty(message = "Please enter minQty")
	private String minQty;
	@NotNull
	@NotEmpty(message = "Please enter maxQty")
	private String maxQty;
	@NotNull
	@NotEmpty(message = "Please enter valid from date")
	private String validFrom;
	@NotNull
	@NotEmpty(message = "Please enter company")
	private String company;
	@NotNull
	@NotEmpty(message = "Please enter valid upto")
	private String validUpto;
	@NotNull
	@NotEmpty(message = "Please enter prordisc")
	private String prordisc;
	@NotNull
	@NotEmpty(message = "Please enter discprlist")
	private String discprlist;
	@NotNull
	@NotEmpty(message = "Please enter forprlist")
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
	

}
