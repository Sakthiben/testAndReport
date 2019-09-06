package com.karya.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lead001mb")
public class Lead001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id")
	private int id;
	
	@Column(name="personname")
	private String  personname;
	
	@Column(name="organisationname")
	private String  organisationname;
	
	@Column(name="status")
	private String  status;
	
	@Column(name="source")
	private String  source;
	
	@Column(name="leadowner")
	private String  leadowner;
	
	@Column(name="nextcontactby")
	private String  nextcontactby;
	
	@Column(name="leadtype")
	private String leadtype;
	
	@Column(name="marketsegment")
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
	
	
	
	
	
