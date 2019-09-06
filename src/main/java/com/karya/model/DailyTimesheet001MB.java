package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dailytimesheet001mb")
public class DailyTimesheet001MB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="timesheet")
	private String timesheet;
	
	@Column(name="employee")
	private String employee;
	
	@Column(name="employeename")
	private String employeename;
	
	@Column(name="fromdatetime")
	private String fromdatetime;
	
	@Column(name="todatetime")
	private String todatetime;
	
	@Column(name="hours")
	private String hours;
	
	@Column(name="activitytype")
	private String activitytype;
	
	@Column(name="task")
	private String task;
	
	@Column(name="project")
	private String project;
	
	@Column(name="status")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
