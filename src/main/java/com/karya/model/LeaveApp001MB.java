package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveapp001mb")
public class LeaveApp001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lvappId")
	private int lvappId;
	
	@Column(name="series")
	private String series;
	
	@Column(name="leaveType")
	private String leaveType;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="leaveApprover")
	private String leaveApprover;
	
	@Column(name="postingDate")
	private String postingDate;
	
	@Column(name="empNumber")
	private String empNumber;
	
	@Column(name="company")
	private String company;

	public int getLvappId() {
		return lvappId;
	}

	public void setLvappId(int lvappId) {
		this.lvappId = lvappId;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getLeaveApprover() {
		return leaveApprover;
	}

	public void setLeaveApprover(String leaveApprover) {
		this.leaveApprover = leaveApprover;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
