package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recruitworkingexperience001mb")
public class RecruitWorkingExperience001MB implements Serializable {
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "workingexperienceId")
	private int workingexperienceId;
	
	@Column(name="applicantNamePrefix")
	private String applicantNamePrefix;
	
	@Column(name="applicantName")
	private String applicantName;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="dateOfJoin")
	private String dateOfJoin;
	
	@Column(name="dateOfRelieve")
	private String dateOfRelieve;
	
	@Column(name="workingexperienceLetter")
	private String workingExperienceLetter;
	
	/**
	 * Get Working Experience Id
	 * @return
	 */
	public int getWorkingExperienceId() {
		return workingexperienceId;
	}

	/**
	 * Set Working Experience Id
	 * @param workingexperienceId
	 */
	public void setWorkingExperienceId(int workingexperienceId) {
		this.workingexperienceId = workingexperienceId;
	}

	/**
	 * Get Application Name Prefix
	 * @return
	 */
	public String getApplicantNamePrefix() {
		return applicantNamePrefix;
	}
	
	/**
	 * Set Application Name Prefix
	 * @param applicantNamePrefix
	 */
	public void setApplicantNamePrefix(String applicantNamePrefix) {
		this.applicantNamePrefix = applicantNamePrefix;
	}
	
	/**
	 * Get Application Name
	 * @return
	 */
	public String getApplicantName() {
		return applicantName;
	}
	
	/**
	 * Set Application Name
	 * @param applicantName
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	/**
	 * Get Company Name
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Set Company Name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * Get Position
	 * @return
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Set Position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Get Grade
	 * @return
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * Set Grade
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * Get Date of Join
	 * @return
	 */
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	
	/**
	 * Set Date of Join
	 * @param dateOfJoin
	 */
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	/**
	 * Get Date of Relieve
	 * @return
	 */
	public String getDateOfRelieve() {
		return dateOfRelieve;
	}
	
	/**
	 * Set Date of Relieve
	 * @param dateOfRelieve
	 */
	public void setDateOfRelieve(String dateOfRelieve) {
		this.dateOfRelieve = dateOfRelieve;
	}

	/**
	 * Get Working Experience Letter
	 * @return
	 */
	public String getWorkingExperienceLetter() {
		return workingExperienceLetter;
	}

	/**
	 * Set Working Experience Letter
	 * @param workingExperienceLetter
	 */
	public void setWorkingExperienceLetter(String workingExperienceLetter) {
		this.workingExperienceLetter = workingExperienceLetter;
	}

	/**
	 * Get Serial Version Id
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
