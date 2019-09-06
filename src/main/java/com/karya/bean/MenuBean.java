package com.karya.bean;

import java.util.ArrayList;
import java.util.List;

public class MenuBean {
	private int id;
	private String menuname;
	private String menulink;
	private String menutype;
	private int parentid;
	private String parentname;
	private String domain;
	private List<ChildMenuBean> childmenu = new ArrayList<ChildMenuBean>();
		
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
	public List<ChildMenuBean> getChildmenu() {
		return childmenu;
	}
	public void setChildmenu(List<ChildMenuBean> childmenu) {
		this.childmenu = childmenu;
	}
}
