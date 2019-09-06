package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="periodclosingvoucher001mb")
public class PeriodClosingVoucher001MB {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="transactiondate")
	private String transactiondate;
	
	@Column(name="closingaccounthead")
	private String closingaccounthead;
	
	@Column(name="postingdate")
	private String postingdate;
	
	@Column(name="closingfiscalyear")
	private String closingfiscalyear;
	
	@Column(name="company")
	private String company;
	
	@Column(name="remarks")
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getClosingaccounthead() {
		return closingaccounthead;
	}

	public void setClosingaccounthead(String closingaccounthead) {
		this.closingaccounthead = closingaccounthead;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getClosingfiscalyear() {
		return closingfiscalyear;
	}

	public void setClosingfiscalyear(String closingfiscalyear) {
		this.closingfiscalyear = closingfiscalyear;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
