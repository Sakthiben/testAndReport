package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stkrepageing001mb")
public class StkRepAgeing001MB implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stageId")
	private int stageId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="itemGroup")
	private String itemGroup;
	
	@Column(name="brand")
	private String brand;
	
	
	@Column(name="averageAge")
	private String averageAge;
	
	@Column(name="earliest")
	private String earliest;
	
	@Column(name="latest")
	private String latest;
	
	@Column(name="UOM")
	private String UOM;

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAverageAge() {
		return averageAge;
	}

	public void setAverageAge(String averageAge) {
		this.averageAge = averageAge;
	}

	public String getEarliest() {
		return earliest;
	}

	public void setEarliest(String earliest) {
		this.earliest = earliest;
	}

	public String getLatest() {
		return latest;
	}

	public void setLatest(String latest) {
		this.latest = latest;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
