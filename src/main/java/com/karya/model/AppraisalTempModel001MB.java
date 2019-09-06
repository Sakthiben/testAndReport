package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apprtemp001mb")

public class AppraisalTempModel001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "apptmpId")
	private int apptmpId;
	
	@Column(name="appraisalTemp")
	private String appraisalTemp;
	
	@Column(name="description")
	private String description;

	public int getApptmpId() {
		return apptmpId;
	}

	public void setApptmpId(int apptmpId) {
		this.apptmpId = apptmpId;
	}

	public String getAppraisalTemp() {
		return appraisalTemp;
	}

	public void setAppraisalTemp(String appraisalTemp) {
		this.appraisalTemp = appraisalTemp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
