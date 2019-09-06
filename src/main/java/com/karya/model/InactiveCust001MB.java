package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inactivecust001mb")
public class InactiveCust001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "inactcustId")
	private int inactcustId;
	
	@Column(name="custType")
	private String custType;
	
	@Column(name="customername")
	private String customername;
	
	@Column(name="terName")
	private String terName;
	
	@Column(name="customergroup")
	private String customergroup;
	
	@Column(name="numoforder")
	private String numoforder;
	
	@Column(name="totalordval")
	private String totalordval;
	
	@Column(name="totalordcons")
	private String totalordcons;
	
	@Column(name="lastordamt")
	private String lastordamt;
	
	@Column(name="lastorddate")
	private String lastorddate;
	
	
	
	@Column(name="daysinlstord")
	private String daysinlstord;



	public int getInactcustId() {
		return inactcustId;
	}



	public void setInactcustId(int inactcustId) {
		this.inactcustId = inactcustId;
	}



	public String getCustType() {
		return custType;
	}



	public void setCustType(String custType) {
		this.custType = custType;
	}



	public String getCustomername() {
		return customername;
	}



	public void setCustomername(String customername) {
		this.customername = customername;
	}



	public String getTerName() {
		return terName;
	}



	public void setTerName(String terName) {
		this.terName = terName;
	}



	public String getCustomergroup() {
		return customergroup;
	}



	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}



	public String getNumoforder() {
		return numoforder;
	}



	public void setNumoforder(String numoforder) {
		this.numoforder = numoforder;
	}



	public String getTotalordval() {
		return totalordval;
	}



	public void setTotalordval(String totalordval) {
		this.totalordval = totalordval;
	}



	public String getTotalordcons() {
		return totalordcons;
	}



	public void setTotalordcons(String totalordcons) {
		this.totalordcons = totalordcons;
	}



	public String getLastordamt() {
		return lastordamt;
	}



	public void setLastordamt(String lastordamt) {
		this.lastordamt = lastordamt;
	}



	public String getLastorddate() {
		return lastorddate;
	}



	public void setLastorddate(String lastorddate) {
		this.lastorddate = lastorddate;
	}



	public String getDaysinlstord() {
		return daysinlstord;
	}



	public void setDaysinlstord(String daysinlstord) {
		this.daysinlstord = daysinlstord;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
