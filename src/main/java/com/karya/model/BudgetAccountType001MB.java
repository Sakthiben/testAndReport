package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budgetaccounttype001mb")
public class BudgetAccountType001MB implements Serializable{
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bgaccId")
	private int bgaccId;
	
	@Column(name="bgaccountType")
	private String bgaccountType;

	public int getBgaccId() {
		return bgaccId;
	}

	public void setBgaccId(int bgaccId) {
		this.bgaccId = bgaccId;
	}

	public String getBgaccountType() {
		return bgaccountType;
	}

	public void setBgaccountType(String bgaccountType) {
		this.bgaccountType = bgaccountType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
