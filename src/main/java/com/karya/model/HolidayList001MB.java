package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holidaylist001mb")
public class HolidayList001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "hlistId")
	private int hlistId;
	
	@Column(name="holidayName")
	private String holidayName;
	
	@Column(name="weeklyOff")
	private String weeklyOff;

	public int getHlistId() {
		return hlistId;
	}

	public void setHlistId(int hlistId) {
		this.hlistId = hlistId;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getWeeklyOff() {
		return weeklyOff;
	}

	public void setWeeklyOff(String weeklyOff) {
		this.weeklyOff = weeklyOff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
