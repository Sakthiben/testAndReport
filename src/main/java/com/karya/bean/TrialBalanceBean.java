package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TrialBalanceBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please Enter Account.")
	private String account;
	
	@Min(value=1)
    @NotNull(message= "Please enter Opening(CR)")
	private int openingcr;
	
	@Min(value=1)
    @NotNull(message= "Please enter Opening(DR)")
	private int openingdr;
	
	@Min(value=1)
    @NotNull(message= "Please enter Credit")
	private int credit;
	
	@Min(value=1)
    @NotNull(message= "Please enter Debit")
	private int debit;
	
	@Min(value=1)
    @NotNull(message= "Please enter Closing(DR)")
	private int closingdr;
	
	@Min(value=1)
    @NotNull(message= "Please enter Closing(CR)")
	private int closingcr;
	
	
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

}
