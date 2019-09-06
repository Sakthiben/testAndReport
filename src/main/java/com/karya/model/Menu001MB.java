package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="menu001mb")
public class Menu001MB {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menuid")
    private int id;
    
	@Column(name = "menuname")
    private String menuname;
	
	@Column(name = "menulink")
    private String menulink;
	
	@Column(name = "menutype")
    private String menutype;
	
	@Column(name = "parentid")
    private int parentid;
	
	@Column(name = "parentname")
	private String parentname;
	
	@Column(name = "domain")
    private String domain;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenulink() {
		return menulink;
	}

	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}

	public String getMenutype() {
		return menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}