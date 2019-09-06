package com.karya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="department001mb")
public class department001MB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="deptid")
	private int deptId;
	
	@Column(name="deptName")
	private String deptName;
	
	@OneToMany(mappedBy="department001mb")
	private Set<Employee001MB> employee001mb;
	

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee001MB> getEmployee001mb() {
		return employee001mb;
	}

	public void setEmployee001mb(Set<Employee001MB> employee001mb) {
		this.employee001mb = employee001mb;
	}
	
	

}
