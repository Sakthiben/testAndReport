package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leavetype001mb")

public class LeaveType001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lvtypeId")
	private int lvtypeId;
	
	@Column(name="lvtypeName")
	private String lvtypeName;
	
	@Column(name="maxdaysAllowed")
	private int maxdaysAllowed;

	public int getLvtypeId() {
		return lvtypeId;
	}

	public void setLvtypeId(int lvtypeId) {
		this.lvtypeId = lvtypeId;
	}

	public String getLvtypeName() {
		return lvtypeName;
	}

	public void setLvtypeName(String lvtypeName) {
		this.lvtypeName = lvtypeName;
	}

	public int getMaxdaysAllowed() {
		return maxdaysAllowed;
	}

	public void setMaxdaysAllowed(int maxdaysAllowed) {
		this.maxdaysAllowed = maxdaysAllowed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
