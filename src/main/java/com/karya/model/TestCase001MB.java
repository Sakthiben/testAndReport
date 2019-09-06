package com.karya.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A simple POJO to represent our user domain  
 *
 */
@Entity
@Table(name="testcase001mb")
public class TestCase001MB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private Long id;
	
	@Column(name="FOLDERNAME", nullable = false)
	private String folderName;
	
	@Column(name="TITLE", nullable = false)
	private String title;
	
	@Column(name="STATUS", nullable = false)
	private String status;
	
	@Column(name="PRIORITY", nullable = true)
	private String priority;
	
	@Column(name="LSTRNRELEASE", nullable = false)
	private String lstrnRelease;//Last Run Release
	
	@Column(name="ASSIGNTO", nullable = false)
	private String assignTo;
	
	@Column(name="LSTRNDATE", nullable = false)
	
	private Date lstrnDate ;
	
	@Column(name="LSTRNSTATUS", nullable = false)
	private String lstrnStatus;
	
	@Column(name="LSTRNTESTSET", nullable = false)
	private String lstrnTestSet;
	
	@Column(name="DATEUPDATED", nullable = false)
	private Date dateUpdated;
	
	@Column(name="EXECTYPE", nullable = false)
	private String execType;
	
	@Column(name="ORIGINALID", nullable = false)
	private String originalId;
	
	@Column(name="TESTTYPE", nullable = false)
	private String testType;
	
	@Column(name="VERSION", nullable = false)
	private String version;
	
	@Column(name="LSTRNBY", nullable = false)
	private String lstrnBy;
	
	@Column(name="OWNER", nullable = false)
	private String owner;
	
	@Column(name="RUNTIME", nullable = false)
	private String runTime;
	
	@Column(name="REVIEWED", nullable = false)
	private String reviewed;
	
	@Column(name="RNBYHOST", nullable = false)
	private String rnbyHost;
	
	@Column(name="AUTOMATED", nullable = false)
	private String automated;
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLstrnBy() {
		return lstrnBy;
	}
	public void setLstrnBy(String lstrnBy) {
		this.lstrnBy = lstrnBy;
	}
	public Date  getLstrnDate() {
		return lstrnDate;
	}
	public void setLstrnDate(Date lstrnDate) {
		this.lstrnDate = lstrnDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getReviewed() {
		return reviewed;
	}
	public void setReviewed(String reviewed) {
		this.reviewed = reviewed;
	}
	public String getRnbyHost() {
		return rnbyHost;
	}
	public void setRnbyHost(String rnbyHost) {
		this.rnbyHost = rnbyHost;
	}
	public String getAutomated() {
		return automated;
	}
	public void setAutomated(String automated) {
		this.automated = automated;
	}
	public String getLstrnStatus() {
		return lstrnStatus;
	}
	public void setLstrnStatus(String lstrnStatus) {
		this.lstrnStatus = lstrnStatus;
	}
	public String getLstrnTestSet() {
		return lstrnTestSet;
	}
	public void setLstrnTestSet(String lstrnTestSet) {
		this.lstrnTestSet = lstrnTestSet;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getExecType() {
		return execType;
	}
	public void setExecType(String execType) {
		this.execType = execType;
	}
	public String getOriginalId() {
		return originalId;
	}
	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/*public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}*/
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLstrnRelease() {
		return lstrnRelease;
	}
	public void setLstrnRelease(String lstrnRelease) {
		this.lstrnRelease = lstrnRelease;
	}
	

}
