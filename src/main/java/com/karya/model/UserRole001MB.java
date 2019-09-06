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
@Table(name="userrole001mb")
public class UserRole001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "userroleid")
	 private int id;
	 
	 @ManyToOne
	 @JoinColumn(name="loginid")
	 private Login001MB login001MB;
	 
	 @Column(name = "role")
	 private String role;
	 
	 @Column(name = "username")
	 private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Login001MB getLogin001MB() {
		return login001MB;
	}

	public void setLogin001MB(Login001MB login001mb) {
		login001MB = login001mb;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
	
	
	
	 
	