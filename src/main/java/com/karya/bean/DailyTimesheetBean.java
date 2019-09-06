package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class DailyTimesheetBean {
	
	private int id;
	@NotNull
	@NotEmpty(message = "Please Enter timesheet")
	private String timesheet;
	
	@NotNull
	@NotEmpty(message = "Please Select Employee Code")
	private String employee;
	
	private String employeename;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String fromdatetime;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String todatetime;
	
	private String postingdate;
	
	@NotNull
	@NotEmpty(message = "Please enter the hours")
	private String hours;
	
	@NotNull
	@NotEmpty(message = "Please enter the activity type")
	private String activitytype;
	
	@NotNull
	@NotEmpty(message = "Please Enter Task")
	private String task;
	
	@NotNull
	@NotEmpty(message = "Please Select Project")
	private String project;
	
	@NotNull
	@NotEmpty(message = "Please Select Date")
	private String status;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(String timesheet) {
		this.timesheet = timesheet;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getFromdatetime() {
		return fromdatetime;
	}
	public void setFromdatetime(String fromdatetime) {
		this.fromdatetime = fromdatetime;
	}
	public String getTodatetime() {
		return todatetime;
	}
	public void setTodatetime(String todatetime) {
		this.todatetime = todatetime;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getActivitytype() {
		return activitytype;
	}
	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	
}
