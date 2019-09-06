package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;
public class PurchaseAnalyticsBean {
	
	private int puansId;
	@NotNull
	 @NotEmpty(message = "Please select treeType")
	private String treeType;
	@NotNull
	 @NotEmpty(message = "Please select basedOn")
	private String basedOn;
	@NotNull
	@NotEmpty(message = "Please select value or quantity")
	private String valueorqty;
	@NotNull
	@NotEmpty(message = "Please enter company")
	private String company;
	@NotNull
	@NotEmpty(message = "Please enter date")
	private String fromDate;
	@NotNull
	@NotEmpty(message = "Please enter date")
	private String toDate;
	@NotNull
	@NotEmpty(message = "Please select range")
	private String anRange;
	public int getPuansId() {
		return puansId;
	}
	public void setPuansId(int puansId) {
		this.puansId = puansId;
	}
	public String getTreeType() {
		return treeType;
	}
	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}
	public String getBasedOn() {
		return basedOn;
	}
	public void setBasedOn(String basedOn) {
		this.basedOn = basedOn;
	}
	public String getValueorqty() {
		return valueorqty;
	}
	public void setValueorqty(String valueorqty) {
		this.valueorqty = valueorqty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getAnRange() {
		return anRange;
	}
	public void setAnRange(String anRange) {
		this.anRange = anRange;
	}
	

}
