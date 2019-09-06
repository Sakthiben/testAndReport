package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemgroup001mb")
public class ItemGroup001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "igId")
	private int igId;
	
	@Column(name="itemGroup")
	private String itemGroup;

	public int getIgId() {
		return igId;
	}

	public void setIgId(int igId) {
		this.igId = igId;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
