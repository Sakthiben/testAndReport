package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CommunicationBean {
	private int commId;
	@NotNull
	@NotEmpty(message = "Please enter Subject")
	
	private String subject;
	@NotNull
	@NotEmpty(message = "Please select Status")
	
	private String status;
	@NotNull
	@NotEmpty(message = "Please select Operation")
	
	private String sentrec;
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSentrec() {
		return sentrec;
	}
	public void setSentrec(String sentrec) {
		this.sentrec = sentrec;
	}
	
}
	
	