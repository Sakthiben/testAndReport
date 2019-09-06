package com.karya.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CustomerAcquisitionBean {
	
	private int id;
	
	/*@NotNull*/
	@Min(1)
	//@Digits(integer=4, fraction=0)
	/*@NotEmpty(message = "Please enter year.")*/
	private int year;
	@NotNull
	@NotEmpty(message = "Please enter month.")
	private String month;
	/*@NotNull*/
	/*@Max(value=1000, message="Please enter newcustomers.")*/
	//@NotEmpty(message = "Please enter newcustomers.")
	@Min(1)
	private int newcustomers;
	/*@NotNull*/
	@Min(1)
	//@NotEmpty(message = "Please enter repeatcustomers.")
	private int repeatcustomers;
	/*@NotNull*/
	@Min(1)
	
	private int total;
	@NotNull
	@Min(value=1,message="Please enter newcustomersrevenue.")
	private Long newcustomersrevenue;
	
	@NotNull
	@Min(value=1,message="Please enter repeatcustomersrevenue.")
		private Long repeatcustomersrevenue;
	@NotNull
	@Min(value=1,message="Please enter totalrevenue.")
	//@NotEmpty(message = "Please enter totalrevenue.")
	private Long totalrevenue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getNewcustomers() {
		return newcustomers;
	}
	public void setNewcustomers(int newcustomers) {
		this.newcustomers = newcustomers;
	}
	public int getRepeatcustomers() {
		return repeatcustomers;
	}
	public void setRepeatcustomers(int repeatcustomers) {
		this.repeatcustomers = repeatcustomers;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Long getNewcustomersrevenue() {
		return newcustomersrevenue;
	}
	public void setNewcustomersrevenue(Long newcustomersrevenue) {
		this.newcustomersrevenue = newcustomersrevenue;
	}
	public Long getRepeatcustomersrevenue() {
		return repeatcustomersrevenue;
	}
	public void setRepeatcustomersrevenue(Long repeatcustomersrevenue) {
		this.repeatcustomersrevenue = repeatcustomersrevenue;
	}
	public Long getTotalrevenue() {
		return totalrevenue;
	}
	public void setTotalrevenue(Long totalrevenue) {
		this.totalrevenue = totalrevenue;
	}
	
}
