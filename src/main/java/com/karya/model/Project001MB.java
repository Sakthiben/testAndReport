package com.karya.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project001mb")
public class Project001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id")
	private int id  ;
	
	@Column(name="projectname")
	private String  projectname  ;
	
	@Column(name="estimatedcost")
	private int  estimatedcost;
	
	@Column(name="startdate")
	private String  startdate;

	@Column(name="enddate")
	private String  enddate;
	
	@Column(name="status")
	private String status ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEstimatedcost() {
		return estimatedcost;
	}

	public void setEstimatedcost(int estimatedcost) {
		this.estimatedcost = estimatedcost;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	
	
		
}

