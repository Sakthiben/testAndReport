package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="updatebank001mb")
public class UpdateBank001MB {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="bankaccount")
	private String bankaccount;
	
	@Column(name="fromdate")
	private String fromdate;
	
	@Column(name="todate")
	private String todate;
	
	@Column(name="customername")
	private String customername;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="chqNumber")
	private String chqNumber;
	
	@Column(name="clearanceDate")
	private String clearanceDate;
	

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}

	public String getClearanceDate() {
		return clearanceDate;
	}

	public void setClearanceDate(String clearanceDate) {
		this.clearanceDate = clearanceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
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
