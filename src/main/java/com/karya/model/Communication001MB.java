package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="communication001mb")
public class Communication001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "commId")
	private int commId;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="status")
	private String status;
	
	@Column(name="sentrec")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
