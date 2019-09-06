package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budgetvarreport001mb")
public class BudgetVarianceReport001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "varId")
	private int varId;
	
	@Column(name="fiscalYear")
	private String fiscalYear;
	
	@Column(name="period")
	private String period;
	
	@Column(name="company")
	private String company;
	
	@Column(name="centerName")
	private String centerName;
	
	@Column(name="bgaccountType")
	private String bgaccountType;
	
	@Column(name="actualjan")
	private String actualjan;
		@Column(name="variancejan")
	private String variancejan;
		
		@Column(name="targetjan")
		private String targetjan;
		
		@Column(name="actualfeb")
		private String actualfeb;
		
		@Column(name="variancefeb")
		private String variancefeb;
		
		@Column(name="targetfeb")
		private String targetfeb;
		
		@Column(name="actualmar")
		private String actualmar;
			@Column(name="variancemar")
		private String variancemar;
			@Column(name="targetmar")
		private String targetmar;
			
		@Column(name="actualapr")
		private String actualapr;
			@Column(name="varianceapr")
		private String varianceapr;
			@Column(name="targetapr")
		private String targetapr;
			
		@Column(name="actualmay")
		private String actualmay;
			@Column(name="variancemay")
		private String variancemay;
			@Column(name="targetmay")
		private String targetmay;
			
		@Column(name="actualjun")
		private String actualjun;
			@Column(name="variancejun")
		private String variancejun;
			@Column(name="targetjun")
		private String targetjun;
			
		@Column(name="actualjul")
		private String actualjul;
			@Column(name="variancejul")
		private String variancejul;
			@Column(name="targetjul")
		private String targetjul;
			
		@Column(name="actualaug")
		private String actualaug;
			@Column(name="varianceaug")
		private String varianceaug;
			@Column(name="targetaug")
		private String targetaug;
			
		@Column(name="actualsep")
		private String actualsep;
			@Column(name="variancesep")
		private String variancesep;
			@Column(name="targetsep")
		private String targetsep;
			
		@Column(name="actualoct")
		private String actualoct;
			@Column(name="varianceoct")
		private String varianceoct;
			@Column(name="targetoct")
		private String targetoct;
			
		@Column(name="actualnov")
		private String actualnov;
			@Column(name="variancenov")
		private String variancenov;
			@Column(name="targetnov")
		private String targetnov;
			
		@Column(name="actualdec")
		private String actualdec;
			@Column(name="variancedec")
		private String variancedec;
			@Column(name="targetdec")
		private String targetdec;
			
			@Column(name="totalTarget")
			private String totalTarget;
				@Column(name="totalActual")
			private String totalActual;
				@Column(name="totalVariance")
			private String totalVariance;
		
		public int getVarId() {
			return varId;
		}
		public void setVarId(int varId) {
			this.varId = varId;
		}
		public String getFiscalYear() {
			return fiscalYear;
		}
		public void setFiscalYear(String fiscalYear) {
			this.fiscalYear = fiscalYear;
		}
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getCenterName() {
			return centerName;
		}
		public void setCenterName(String centerName) {
			this.centerName = centerName;
		}
		public String getBgaccountType() {
			return bgaccountType;
		}
		public void setBgaccountType(String bgaccountType) {
			this.bgaccountType = bgaccountType;
		}
		public String getActualjan() {
			return actualjan;
		}
		public void setActualjan(String actualjan) {
			this.actualjan = actualjan;
		}
		public String getVariancejan() {
			return variancejan;
		}
		public void setVariancejan(String variancejan) {
			this.variancejan = variancejan;
		}
		public String getTargetjan() {
			return targetjan;
		}
		public void setTargetjan(String targetjan) {
			this.targetjan = targetjan;
		}
		public String getActualfeb() {
			return actualfeb;
		}
		public void setActualfeb(String actualfeb) {
			this.actualfeb = actualfeb;
		}
		public String getVariancefeb() {
			return variancefeb;
		}
		public void setVariancefeb(String variancefeb) {
			this.variancefeb = variancefeb;
		}
		public String getTargetfeb() {
			return targetfeb;
		}
		public void setTargetfeb(String targetfeb) {
			this.targetfeb = targetfeb;
		}
		public String getActualmar() {
			return actualmar;
		}
		public void setActualmar(String actualmar) {
			this.actualmar = actualmar;
		}
		public String getVariancemar() {
			return variancemar;
		}
		public void setVariancemar(String variancemar) {
			this.variancemar = variancemar;
		}
		public String getTargetmar() {
			return targetmar;
		}
		public void setTargetmar(String targetmar) {
			this.targetmar = targetmar;
		}
		public String getActualapr() {
			return actualapr;
		}
		public void setActualapr(String actualapr) {
			this.actualapr = actualapr;
		}
		public String getVarianceapr() {
			return varianceapr;
		}
		public void setVarianceapr(String varianceapr) {
			this.varianceapr = varianceapr;
		}
		public String getTargetapr() {
			return targetapr;
		}
		public void setTargetapr(String targetapr) {
			this.targetapr = targetapr;
		}
		public String getActualmay() {
			return actualmay;
		}
		public void setActualmay(String actualmay) {
			this.actualmay = actualmay;
		}
		public String getVariancemay() {
			return variancemay;
		}
		public void setVariancemay(String variancemay) {
			this.variancemay = variancemay;
		}
		public String getTargetmay() {
			return targetmay;
		}
		public void setTargetmay(String targetmay) {
			this.targetmay = targetmay;
		}
		public String getActualjun() {
			return actualjun;
		}
		public void setActualjun(String actualjun) {
			this.actualjun = actualjun;
		}
		public String getVariancejun() {
			return variancejun;
		}
		public void setVariancejun(String variancejun) {
			this.variancejun = variancejun;
		}
		public String getTargetjun() {
			return targetjun;
		}
		public void setTargetjun(String targetjun) {
			this.targetjun = targetjun;
		}
		public String getActualjul() {
			return actualjul;
		}
		public void setActualjul(String actualjul) {
			this.actualjul = actualjul;
		}
		public String getVariancejul() {
			return variancejul;
		}
		public void setVariancejul(String variancejul) {
			this.variancejul = variancejul;
		}
		public String getTargetjul() {
			return targetjul;
		}
		public void setTargetjul(String targetjul) {
			this.targetjul = targetjul;
		}
		public String getActualaug() {
			return actualaug;
		}
		public void setActualaug(String actualaug) {
			this.actualaug = actualaug;
		}
		public String getVarianceaug() {
			return varianceaug;
		}
		public void setVarianceaug(String varianceaug) {
			this.varianceaug = varianceaug;
		}
		public String getTargetaug() {
			return targetaug;
		}
		public void setTargetaug(String targetaug) {
			this.targetaug = targetaug;
		}
		public String getActualsep() {
			return actualsep;
		}
		public void setActualsep(String actualsep) {
			this.actualsep = actualsep;
		}
		public String getVariancesep() {
			return variancesep;
		}
		public void setVariancesep(String variancesep) {
			this.variancesep = variancesep;
		}
		public String getTargetsep() {
			return targetsep;
		}
		public void setTargetsep(String targetsep) {
			this.targetsep = targetsep;
		}
		public String getActualoct() {
			return actualoct;
		}
		public void setActualoct(String actualoct) {
			this.actualoct = actualoct;
		}
		public String getVarianceoct() {
			return varianceoct;
		}
		public void setVarianceoct(String varianceoct) {
			this.varianceoct = varianceoct;
		}
		public String getTargetoct() {
			return targetoct;
		}
		public void setTargetoct(String targetoct) {
			this.targetoct = targetoct;
		}
		public String getActualnov() {
			return actualnov;
		}
		public void setActualnov(String actualnov) {
			this.actualnov = actualnov;
		}
		public String getVariancenov() {
			return variancenov;
		}
		public void setVariancenov(String variancenov) {
			this.variancenov = variancenov;
		}
		public String getTargetnov() {
			return targetnov;
		}
		public void setTargetnov(String targetnov) {
			this.targetnov = targetnov;
		}
		public String getActualdec() {
			return actualdec;
		}
		public void setActualdec(String actualdec) {
			this.actualdec = actualdec;
		}
		public String getVariancedec() {
			return variancedec;
		}
		public void setVariancedec(String variancedec) {
			this.variancedec = variancedec;
		}
		public String getTargetdec() {
			return targetdec;
		}
		public void setTargetdec(String targetdec) {
			this.targetdec = targetdec;
		}
		public String getTotalTarget() {
			return totalTarget;
		}
		public void setTotalTarget(String totalTarget) {
			this.totalTarget = totalTarget;
		}
		public String getTotalActual() {
			return totalActual;
		}
		public void setTotalActual(String totalActual) {
			this.totalActual = totalActual;
		}
		public String getTotalVariance() {
			return totalVariance;
		}
		public void setTotalVariance(String totalVariance) {
			this.totalVariance = totalVariance;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
	


}
