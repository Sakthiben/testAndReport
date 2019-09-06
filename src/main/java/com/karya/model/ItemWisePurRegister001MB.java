package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemwisepurregister001mb")
public class ItemWisePurRegister001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "iwprId")
	private int iwprId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="itemGroup")
	private String itemGroup;


	@Column(name="inVoice")
	private String inVoice;
	
	@Column(name="postingDate")
	private String postingDate;

	@Column(name="supName")
	private String supName;
	
	@Column(name="payAccount")
	private String payAccount;

	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="projectname")
	private String projectname;

	
	@Column(name="company")
	private String company;
	
	@Column(name="poSeries")
	private String poSeries;

	@Column(name="purtName")
	private String purtName;
	
	@Column(name="expenseAccount")
	private String expenseAccount;

	@Column(name="quantity")
	private String quantity;
	
	@Column(name="rate")
	private String rate;

	@Column(name="amount")
	private String amount;
	
	@Column(name="totalTax")
	private String totalTax;

	@Column(name="total")
	private String total;
	
	@Column(name="currency")
	private String currency;

	public int getIwprId() {
		return iwprId;
	}

	public void setIwprId(int iwprId) {
		this.iwprId = iwprId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getInVoice() {
		return inVoice;
	}

	public void setInVoice(String inVoice) {
		this.inVoice = inVoice;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPoSeries() {
		return poSeries;
	}

	public void setPoSeries(String poSeries) {
		this.poSeries = poSeries;
	}

	public String getPurtName() {
		return purtName;
	}

	public void setPurtName(String purtName) {
		this.purtName = purtName;
	}

	public String getExpenseAccount() {
		return expenseAccount;
	}

	public void setExpenseAccount(String expenseAccount) {
		this.expenseAccount = expenseAccount;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
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

	public String getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
