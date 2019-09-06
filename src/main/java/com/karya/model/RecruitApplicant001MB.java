package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recruitapplicant001mb")
public class RecruitApplicant001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "appId")
	private int appId;
	
	@Column(name="applicantName")
	private String applicantName;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="jobId")
	private RecruitOpening001MB recruitopening001mb;
	
	@Column(name="jobName")
	private String jobName;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RecruitOpening001MB getRecruitopening001mb() {
		return recruitopening001mb;
	}

	public void setRecruitopening001mb(RecruitOpening001MB recruitopening001mb) {
		this.recruitopening001mb = recruitopening001mb;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
