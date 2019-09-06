package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



public class LeadBean {
	
	 private int id;
	 @NotNull
		@NotEmpty(message = "Please enter person name.") 
	 private String personname;
	 @NotNull
		@NotEmpty(message = "Please enter organisation name.") 
	 private String organisationname;
	 @NotNull
		@NotEmpty(message = "Please enter the status") 
	 private String status;
	 
	 @NotNull
		@NotEmpty(message = "Please enter source") 
	 private String source;
	 @NotNull
		@NotEmpty(message = "Please enter lead owner.") 
	 private String leadowner;
	 @NotNull
	 @NotEmpty(message = "Please enter next contact by") 
	 private String nextcontactby;
	 @NotNull
		@NotEmpty(message = "Please enter lead type") 
	 private String leadtype;
	 @NotNull
		@NotEmpty(message = "Please enter marketsegment") 
	 private String marketsegment;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getOrganisationname() {
		return organisationname;
	}
	public void setOrganisationname(String organisationname) {
		this.organisationname = organisationname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLeadowner() {
		return leadowner;
	}
	public void setLeadowner(String leadowner) {
		this.leadowner = leadowner;
	}
	public String getNextcontactby() {
		return nextcontactby;
	}
	public void setNextcontactby(String nextcontactby) {
		this.nextcontactby = nextcontactby;
	}
	public String getLeadtype() {
		return leadtype;
	}
	public void setLeadtype(String leadtype) {
		this.leadtype = leadtype;
	}
	public String getMarketsegment() {
		return marketsegment;
	}
	public void setMarketsegment(String marketsegment) {
		this.marketsegment = marketsegment;
	}
	 
     
} 
     