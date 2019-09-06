package com.karya.bean;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class CustomerCreditBalanceBean {
	
	private Integer id;
	
	@NotNull
	@Min(value=1,message="Please enter credit limit.")
	
	private Long creditlimit;
	
	@NotNull
	@Min(value=1,message="Please enter outstandingamount.")
	
	private Long outstandingamount;
	
	@NotNull
	@Min(value=1,message="Please enter credit balance.")
	
	
	private Long creditbalance;
	private Integer ccid;
	
	@NotNull
	@NotEmpty(message="Please Select Customer ")	
	private String customername;
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Integer getCcid() {
		return ccid;
	}
	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getCreditlimit() {
		return creditlimit;
	}
	public void setCreditlimit(Long creditlimit) {
		this.creditlimit = creditlimit;
	}
	public Long getOutstandingamount() {
		return outstandingamount;
	}
	public void setOutstandingamount(Long outstandingamount) {
		this.outstandingamount = outstandingamount;
	}
	public Long getCreditbalance() {
		return creditbalance;
	}
	public void setCreditbalance(Long creditbalance) {
		this.creditbalance = creditbalance;
	}

}
