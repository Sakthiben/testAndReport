package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SalesTaxesBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Title")
	private String title;
	
	@NotNull
	@NotEmpty(message = "Please Enter Company Name.")
	private String company;
	
	@NotNull
	@NotEmpty(message = "Please Enter Type")
	private String type;
	
	@NotNull
	@NotEmpty(message = "Please Enter AccountHead")
	private String accounthead;
	
	@Min(value=1)
    @NotNull(message= "Please enter Rate")
	private int rate;
	
	@Min(value=1)
    @NotNull(message= "Please enter Amount")
	private int amount;
	
	@Min(value=1)
    @NotNull(message= "Please enter Total")
	private int total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccounthead() {
		return accounthead;
	}
	public void setAccounthead(String accounthead) {
		this.accounthead = accounthead;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
