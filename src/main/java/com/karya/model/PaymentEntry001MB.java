package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymententry001mb")
public class PaymentEntry001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "payentId")
	private int payentId;
	
	@Column(name="entrySeries")
	private String entrySeries;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="paymentType")
	private String paymentType;
	
	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="partyType")
	private String partyType;
	
	@Column(name="partyName")
	private String partyName;
	
	@Column(name="accpaidTo")
	private String accpaidTo;

	public int getPayentId() {
		return payentId;
	}

	public void setPayentId(int payentId) {
		this.payentId = payentId;
	}

	public String getEntrySeries() {
		return entrySeries;
	}

	public void setEntrySeries(String entrySeries) {
		this.entrySeries = entrySeries;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getAccpaidTo() {
		return accpaidTo;
	}

	public void setAccpaidTo(String accpaidTo) {
		this.accpaidTo = accpaidTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	



}
