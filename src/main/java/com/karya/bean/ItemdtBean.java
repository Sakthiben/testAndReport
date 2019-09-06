package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemdtBean {
	
	
	private int itemId;
	@NotNull
	@NotEmpty(message= "Please enter item code")
	private String itemCode;
	@NotNull
	@Min(1)
	private Integer quantity;
	@NotNull
	@NotEmpty(message= "Please enter rate")
	private String rate;
	@NotNull
	@NotEmpty(message= "Please enter amount")
	private String amount;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
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
	

}
