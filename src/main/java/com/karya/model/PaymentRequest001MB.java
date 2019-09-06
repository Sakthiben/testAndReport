package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentrequest001mb")
public class PaymentRequest001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "payreqId")
	private int payreqId;
	
	@Column(name="prName")
	private String prName;
	
	@Column(name="status")
	private String status;

	public int getPayreqId() {
		return payreqId;
	}

	public void setPayreqId(int payreqId) {
		this.payreqId = payreqId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
