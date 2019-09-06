package com.karya.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recruitopening001mb")
public class RecruitOpening001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "jobId")
	private int jobId;
	
	@Column(name="jobName")
	private String jobName;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(mappedBy="recruitopening001mb")
	private Set<RecruitApplicant001MB> recruitapplicant001mb;
	

	public Set<RecruitApplicant001MB> getRecruitapplicant001mb() {
		return recruitapplicant001mb;
	}

	public void setRecruitapplicant001mb(Set<RecruitApplicant001MB> recruitapplicant001mb) {
		this.recruitapplicant001mb = recruitapplicant001mb;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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
