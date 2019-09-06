package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;
public class PuOrderTrendBean {
	
	private int ptrId;
	@NotNull
	@NotEmpty(message = "Please select the period")
	private String period;
	@NotNull
	@NotEmpty(message = "Please select basedOn")
	private String basedOn;
	@NotNull
	@NotEmpty(message = "Please select fiscalYear")
	private String fiscalYear;
	@NotNull
	@NotEmpty(message = "Please enter company")
	private String company;
	@NotNull
	@NotEmpty(message = "Please select item code")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter janQty")
	private String janQty;
	@NotNull
	@NotEmpty(message = "Please enter janAmt")
	private String janAmt;
	@NotNull
	@NotEmpty(message = "Please enter febQty")
	private String febQty;
	@NotNull
	@NotEmpty(message = "Please enter febAmt")
	private String febAmt;
	@NotNull
	@NotEmpty(message = "Please enter marQty")
	private String marQty;
	@NotNull
	@NotEmpty(message = "Please enter marAmt")
	private String marAmt;
	@NotNull
	@NotEmpty(message = "Please enter aprQty")
	private String aprQty;
	@NotNull
	@NotEmpty(message = "Please enter aprAmt")
	private String aprAmt;
	@NotNull
	@NotEmpty(message = "Please enter mayQty")
	private String mayQty;
	@NotNull
	@NotEmpty(message = "Please enter mayAmt")
	private String mayAmt;
	@NotNull
	@NotEmpty(message = "Please enter junQty")
	private String junQty;
	@NotNull
	@NotEmpty(message = "Please enter junAmt")
	private String junAmt;
	@NotNull
	@NotEmpty(message = "Please enter julQty")
	private String julQty;
	@NotNull
	@NotEmpty(message = "Please enter julAmt")
	private String julAmt;
	@NotNull
	@NotEmpty(message = "Please enter augQty")
	private String augQty;
	@NotNull
	@NotEmpty(message = "Please enter augAmt")
	private String augAmt;
	@NotNull
	@NotEmpty(message = "Please enter sepQty")
	private String sepQty;
	@NotNull
	@NotEmpty(message = "Please enter sepAmt")
	private String sepAmt;
	@NotNull
	@NotEmpty(message = "Please enter octQty")
	private String octQty;
	@NotNull
	@NotEmpty(message = "Please enter octAmt")
	private String octAmt;
	@NotNull
	@NotEmpty(message = "Please enter novQty")
	private String novQty;
	@NotNull
	@NotEmpty(message = "Please enter novAmt")
	private String novAmt;
	@NotNull
	@NotEmpty(message = "Please enter decQty")
	private String decQty;
	@NotNull
	@NotEmpty(message = "Please enter decAmt")
	private String decAmt;
	@NotNull
	@NotEmpty(message = "Please enter totalQty")
	private String totalQty;
	@NotNull
	@NotEmpty(message = "Please enter totalAmt")
	private String totalAmt;
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
	public String getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	

}
