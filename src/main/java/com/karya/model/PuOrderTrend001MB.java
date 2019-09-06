package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="puordTrends001mb")
public class PuOrderTrend001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ptrId")
	private int ptrId;
	
	@Column(name="period")
	private String period;
	
	@Column(name="basedOn")
	private String basedOn;
	
	@Column(name="fiscalYear")
	private String fiscalYear;
	
	@Column(name="company")
	private String company;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="janQty")
	private String janQty;
	
	@Column(name="janAmt")
	private String janAmt;
	
	@Column(name="febQty")
	private String febQty;
	
	@Column(name="febAmt")
	private String febAmt;
	
	@Column(name="marQty")
	private String marQty;
	
	@Column(name="marAmt")
	private String marAmt;
	
	@Column(name="aprQty")
	private String aprQty;
	
	@Column(name="aprAmt")
	private String aprAmt;

	
	
	@Column(name="mayQty")
	private String mayQty;
	
	@Column(name="mayAmt")
	private String mayAmt;
	
	@Column(name="junQty")
	private String junQty;
	
	@Column(name="junAmt")
	private String junAmt;
	
	@Column(name="julQty")
	private String julQty;
	
	@Column(name="julAmt")
	private String julAmt;
	
	
	@Column(name="augAmt")
	private String augAmt;
	
	@Column(name="augQtyt")
	private String augQty;
	
	
	@Column(name="sepQty")
	private String sepQty;
	
	@Column(name="sepAmt")
	private String sepAmt;
	
	
	
	@Column(name="octQty")
	private String octQty;
	
	@Column(name="octAmt")
	private String octAmt;
	
	@Column(name="novQty")
	private String novQty;
	
	@Column(name="novAmt")
	private String novAmt;
	
	@Column(name="decQty")
	private String decQty;
	
	@Column(name="decAmt")
	private String decAmt;
	
	@Column(name="totalAmt")
	private String totalAmt;
	
	@Column(name="totalQty")
	private String totalQty;

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

	public String getJulAmt() {
		return julAmt;
	}

	public void setJulAmt(String julAmt) {
		this.julAmt = julAmt;
	}

	public String getAugQty() {
		return augQty;
	}

	public void setAugQty(String augQty) {
		this.augQty = augQty;
	}

	public int getPtrId() {
		return ptrId;
	}

	public void setPtrId(int ptrId) {
		this.ptrId = ptrId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(String basedOn) {
		this.basedOn = basedOn;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getJanQty() {
		return janQty;
	}

	public void setJanQty(String janQty) {
		this.janQty = janQty;
	}

	public String getJanAmt() {
		return janAmt;
	}

	public void setJanAmt(String janAmt) {
		this.janAmt = janAmt;
	}

	public String getFebQty() {
		return febQty;
	}

	public void setFebQty(String febQty) {
		this.febQty = febQty;
	}

	public String getFebAmt() {
		return febAmt;
	}

	public void setFebAmt(String febAmt) {
		this.febAmt = febAmt;
	}

	public String getMarQty() {
		return marQty;
	}

	public void setMarQty(String marQty) {
		this.marQty = marQty;
	}

	public String getMarAmt() {
		return marAmt;
	}

	public void setMarAmt(String marAmt) {
		this.marAmt = marAmt;
	}

	public String getAprQty() {
		return aprQty;
	}

	public void setAprQty(String aprQty) {
		this.aprQty = aprQty;
	}

	public String getAprAmt() {
		return aprAmt;
	}

	public void setAprAmt(String aprAmt) {
		this.aprAmt = aprAmt;
	}

	public String getMayQty() {
		return mayQty;
	}

	public void setMayQty(String mayQty) {
		this.mayQty = mayQty;
	}

	public String getMayAmt() {
		return mayAmt;
	}

	public void setMayAmt(String mayAmt) {
		this.mayAmt = mayAmt;
	}

	public String getJunQty() {
		return junQty;
	}

	public void setJunQty(String junQty) {
		this.junQty = junQty;
	}

	public String getJunAmt() {
		return junAmt;
	}

	public void setJunAmt(String junAmt) {
		this.junAmt = junAmt;
	}

	public String getJulQty() {
		return julQty;
	}

	public void setJulQty(String julQty) {
		this.julQty = julQty;
	}

	public String getAugAmt() {
		return augAmt;
	}

	public void setAugAmt(String augAmt) {
		this.augAmt = augAmt;
	}

	public String getSepQty() {
		return sepQty;
	}

	public void setSepQty(String sepQty) {
		this.sepQty = sepQty;
	}

	public String getSepAmt() {
		return sepAmt;
	}

	public void setSepAmt(String sepAmt) {
		this.sepAmt = sepAmt;
	}

	public String getOctQty() {
		return octQty;
	}

	public void setOctQty(String octQty) {
		this.octQty = octQty;
	}

	public String getOctAmt() {
		return octAmt;
	}

	public void setOctAmt(String octAmt) {
		this.octAmt = octAmt;
	}

	public String getNovQty() {
		return novQty;
	}

	public void setNovQty(String novQty) {
		this.novQty = novQty;
	}

	public String getNovAmt() {
		return novAmt;
	}

	public void setNovAmt(String novAmt) {
		this.novAmt = novAmt;
	}

	public String getDecQty() {
		return decQty;
	}

	public void setDecQty(String decQty) {
		this.decQty = decQty;
	}

	public String getDecAmt() {
		return decAmt;
	}

	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	
	
	

}
