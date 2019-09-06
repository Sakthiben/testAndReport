package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customercreditbalance001mb")
public class CustomerCreditBalance001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ccid")
	private Integer ccid;
	
	@Column(name="Customername")
	private String customername;
	
	@Column(name="creditlimit")
	private Long creditlimit;
	
	@Column(name="outstandingamount")
	private Long outstandingamount;
	
	@Column(name="creditbalance")
	private Long creditbalance;
	
	@ManyToOne
	@JoinColumn(name="id")
	private CustomerDetails001MB customerdetails001MB;

	public Integer getCcid() {
		return ccid;
	}

	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
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

	public CustomerDetails001MB getCustomerdetails001MB() {
		return customerdetails001MB;
	}

	public void setCustomerdetails001MB(CustomerDetails001MB customerdetails001mb) {
		customerdetails001MB = customerdetails001mb;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	
}
