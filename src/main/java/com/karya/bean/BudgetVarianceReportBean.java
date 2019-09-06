package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BudgetVarianceReportBean {
	
	private int varId;
	
	@NotNull
	 @NotEmpty(message = "Please enter fiscal year")
	private String fiscalYear;
	
	@NotNull
	 @NotEmpty(message = "Please enter period")
	private String period;
	
	@NotNull
	 @NotEmpty(message = "Please enter company")
	private String company;
	
	@NotNull
	 @NotEmpty(message = "Please enter center name")
	private String centerName;
	
	@NotNull
	 @NotEmpty(message = "Please enter budget account type")
	private String bgaccountType;
	
	private String actualjan;
	private String variancejan;
	private String targetjan;
	private String actualfeb;
	private String variancefeb;
	private String targetfeb;
	private String actualmar;
	private String variancemar;
	private String targetmar;
	private String actualapr;
	private String varianceapr;
	private String targetapr;
	private String actualmay;
	private String variancemay;
	private String targetmay;
	private String actualjun;
	private String variancejun;
	private String targetjun;
	private String actualjul;
	private String variancejul;
	private String targetjul;
	private String actualaug;
	private String varianceaug;
	private String targetaug;
	private String actualsep;
	private String variancesep;
	private String targetsep;
	private String actualoct;
	private String varianceoct;
	private String targetoct;
	
	private String actualnov;
	private String variancenov;
	private String targetnov;
	
	private String targetdec;
	private String actualdec;
	private String variancedec;
	private String totalTarget;
	private String totalActual;
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
	public String getTargetdec() {
		return targetdec;
	}
	public void setTargetdec(String targetdec) {
		this.targetdec = targetdec;
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
	
	
	

}
