package com.karya.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LeaveAppBean {
	
	private int lvappId;
	@NotNull
	@NotEmpty(message = "Please enter applicant name")
	private String series;
	@NotNull
	@NotEmpty(message = "Please select status")
	private String leaveType;
	 @NotNull
	 @Size(min=2, max=200, message="Please enter description below 200 characters") 
	private String reason;
	 @NotNull
	 @NotEmpty(message = "Please enter Date")
	private String fromDate;
	 @NotNull
	 @NotEmpty(message = "Please enter date")
	 
	private String toDate;
	 @NotNull
	 @NotEmpty(message = "Please enter leave approver")
	private String leaveApprover;
	 @NotNull
	 @NotEmpty(message = "Please enter date")
	private String postingDate;
	private int sNo;
	@NotNull
	@NotEmpty(message = "Please select Employee Number")
	private String empNumber;
	
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
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
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
}
