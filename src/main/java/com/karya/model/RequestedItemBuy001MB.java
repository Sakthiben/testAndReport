package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requestItembuy001mb")
public class RequestedItemBuy001MB implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "riId")
	private int riId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="warehouse")
	private String warehouse;
	
	@Column(name="actual")
	private String actual;
	
	@Column(name="requested")
	private String requested;
	
	@Column(name="reserved")
	private String reserved;
	
	@Column(name="ordered")
	private String ordered;
	
	@Column(name="projected")
	private String projected;

	public int getRiId() {
		return riId;
	}

	public void setRiId(int riId) {
		this.riId = riId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getRequested() {
		return requested;
	}

	public void setRequested(String requested) {
		this.requested = requested;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getOrdered() {
		return ordered;
	}

	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}

	public String getProjected() {
		return projected;
	}

	public void setProjected(String projected) {
		this.projected = projected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
