package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task001mb")
public class Task001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "taskid")
	private int taskid  ;
	
	@Column(name="taskdescription")
	private String  taskdescription  ;
	
	@Column(name="AssignTo")
	private String AssignTo;
	
	@Column(name="AssignBy")
	private String AssignBy ;
	
	@Column(name="status")
	private String status ;
	
	@Column(name="starton")
	private String starton;
	
	@Column(name="endon")
	private String endon ;
	
	@Column(name="allday")
	private boolean allday ;
	
	@Column(name="sendanemail")
	private boolean sendanemail ;
	
	@Column(name="repeatthisevent")
	private boolean repeatthisevent ;
	
	@Column(name="projectname")
	private String projectname;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="projectid")
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
		return AssignTo;
	}

	public void setAssignTo(String assignTo) {
		AssignTo = assignTo;
	}

	public String getAssignBy() {
		return AssignBy;
	}

	public void setAssignBy(String assignBy) {
		AssignBy = assignBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}