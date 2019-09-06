package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TaskBean{
	
	private int taskid  ;
	
	@NotNull
	@NotEmpty(message = "Please enter the task description")
	private String  taskdescription  ;
	
	@NotNull
	@NotEmpty(message = "Please select assignTo")
	private String assignTo ;
	
	@NotNull
	@NotEmpty(message = "Please select assign by")
	private String assignBy ;
	
	@NotNull
	@NotEmpty(message = "Please enter the status")
	private String status ;
	
	@NotNull
	@NotEmpty(message = "Please Select Date And Time")
	private String starton;
	
	@NotNull
	@NotEmpty(message = "Please Select Date And Time")
	private String endon;
	
	private boolean allday;
	
	private boolean sendanemail;
	
	private boolean repeatthisevent;
	
	@NotNull
	@NotEmpty(message = "Please Select Project First")
	private String projectname;
	
	private String duration;
	
	private int projectid;
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStarton() {
		return starton;
	}
	public void setStarton(String starton) {
		this.starton = starton;
	}
	public String getEndon() {
		return endon;
	}
	public void setEndon(String endon) {
		this.endon = endon;
	}
	public boolean isAllday() {
		return allday;
	}
	public void setAllday(boolean allday) {
		this.allday = allday;
	}
	public boolean isSendanemail() {
		return sendanemail;
	}
	public void setSendanemail(boolean sendanemail) {
		this.sendanemail = sendanemail;
	}
	public boolean isRepeatthisevent() {
		return repeatthisevent;
	}
	public void setRepeatthisevent(boolean repeatthisevent) {
		this.repeatthisevent = repeatthisevent;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getAssignBy() {
		return assignBy;
	}
	public void setAssignBy(String assignBy) {
		this.assignBy = assignBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
