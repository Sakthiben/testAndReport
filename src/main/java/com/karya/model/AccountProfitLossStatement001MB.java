package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accprofitlossstatement001mb")
public class AccountProfitLossStatement001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "aplsId")
	private int aplsId;
	
	@Column(name="company")
	private String company;
	
	@Column(name="startYear")
	private String startYear;
	
	@Column(name="endYear")
	private String endYear;
	
	@Column(name="periodicity")
	private String periodicity;
	
	@Column(name="account")
	private String account;
	
	@Column(name="costcenter")
	private String costcenter;
	
	@Column(name="projectname")
	private String projectname;
	
	@Column(name="jan")
	private String jan;
	
	@Column(name="feb")
	private String feb;
	
	@Column(name="mar")
	private String mar;
	@Column(name="apr")
	private String apr;
	
	@Column(name="may")
	private String may;
	@Column(name="jun")
	private String jun;
	
	@Column(name="jul")
	private String jul;
	@Column(name="aug")
	private String aug;
	
	@Column(name="sep")
	private String sep;
	@Column(name="oct")
	private String oct;
	
	@Column(name="nov")
	private String nov;
	@Column(name="dece")
	private String dece;
	public int getAplsId() {
		return aplsId;
	}
	public void setAplsId(int aplsId) {
		this.aplsId = aplsId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCostcenter() {
		return costcenter;
	}
	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getJan() {
		return jan;
	}
	public void setJan(String jan) {
		this.jan = jan;
	}
	public String getFeb() {
		return feb;
	}
	public void setFeb(String feb) {
		this.feb = feb;
	}
	public String getMar() {
		return mar;
	}
	public void setMar(String mar) {
		this.mar = mar;
	}
	public String getApr() {
		return apr;
	}
	public void setApr(String apr) {
		this.apr = apr;
	}
	public String getMay() {
		return may;
	}
	public void setMay(String may) {
		this.may = may;
	}
	public String getJun() {
		return jun;
	}
	public void setJun(String jun) {
		this.jun = jun;
	}
	public String getJul() {
		return jul;
	}
	public void setJul(String jul) {
		this.jul = jul;
	}
	public String getAug() {
		return aug;
	}
	public void setAug(String aug) {
		this.aug = aug;
	}
	public String getSep() {
		return sep;
	}
	public void setSep(String sep) {
		this.sep = sep;
	}
	public String getOct() {
		return oct;
	}
	public void setOct(String oct) {
		this.oct = oct;
	}
	public String getNov() {
		return nov;
	}
	public void setNov(String nov) {
		this.nov = nov;
	}
	
	public String getDece() {
		return dece;
	}
	public void setDece(String dece) {
		this.dece = dece;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
