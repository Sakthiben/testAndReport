package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expensesclm001mb")
public class ExpenseClaimModel001MB implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "expclmId")
	private int expclmId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="totalclmAmt")
	private String totalclmAmt;
	
	@Column(name="expCode")
	private String expCode;
	
	@Column(name="expType")
	private String expType;

	public int getExpclmId() {
		return expclmId;
	}

	public void setExpclmId(int expclmId) {
		this.expclmId = expclmId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalclmAmt() {
		return totalclmAmt;
	}

	public void setTotalclmAmt(String totalclmAmt) {
		this.totalclmAmt = totalclmAmt;
	}

	public String getExpCode() {
		return expCode;
	}

	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
