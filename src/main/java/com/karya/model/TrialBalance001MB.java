package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trialbalance001mb")
public class TrialBalance001MB {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="account")
	private String account;
	
	@Column(name="openingcr")
	private int openingcr;
	
	@Column(name="openingdr")
	private int openingdr;
	
	@Column(name="closingdr")
	private int closingdr;
	
	@Column(name="closingcr")
	private int closingcr;
	
	@Column(name="credit")
	private int credit;
	
	@Column(name="debit")
	private int debit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getOpeningcr() {
		return openingcr;
	}

	public void setOpeningcr(int openingcr) {
		this.openingcr = openingcr;
	}

	public int getOpeningdr() {
		return openingdr;
	}

	public void setOpeningdr(int openingdr) {
		this.openingdr = openingdr;
	}

	public int getClosingdr() {
		return closingdr;
	}

	public void setClosingdr(int closingdr) {
		this.closingdr = closingdr;
	}

	public int getClosingcr() {
		return closingcr;
	}

	public void setClosingcr(int closingcr) {
		this.closingcr = closingcr;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
