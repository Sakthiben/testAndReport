package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;	

@Entity
@Table(name="customeracquisition001mb")
public class CustomerAcquisition001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="month")
	private String month;
	
	@Column(name="newcustomers")
	private Integer newcustomers;
	
	@Column(name="repeatcustomers")
	private Integer repeatcustomers;	
	
	@Column(name="total")
	private Integer total;
	
	@Column(name="newcustomersrevenue")
	private Long newcustomersrevenue;
	
	@Column(name="repeatcustomersrevenue")
	private Long repeatcustomersrevenue;
	
	@Column(name="totalrevenue")
	private Long totalrevenue;
	
	public Long getRepeatcustomersrevenue() {
		return repeatcustomersrevenue;
	}

	public void setRepeatcustomersrevenue(Long repeatcustomersrevenue) {
		this.repeatcustomersrevenue = repeatcustomersrevenue;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getNewcustomers() {
		return newcustomers;
	}

	public void setNewcustomers(Integer newcustomers) {
		this.newcustomers = newcustomers;
	}

	public Integer getRepeatcustomers() {
		return repeatcustomers;
	}

	public void setRepeatcustomers(Integer repeatcustomers) {
		this.repeatcustomers = repeatcustomers;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getNewcustomersrevenue() {
		return newcustomersrevenue;
	}

	public void setNewcustomersrevenue(Long newcustomersrevenue) {
		this.newcustomersrevenue = newcustomersrevenue;
	}

	public Long getTotalrevenue() {
		return totalrevenue;
	}

	public void setTotalrevenue(Long totalrevenue) {
		this.totalrevenue = totalrevenue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
