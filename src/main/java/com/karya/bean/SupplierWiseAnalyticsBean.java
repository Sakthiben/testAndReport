package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;
public class SupplierWiseAnalyticsBean {
	private int swsId;
	@NotNull
	@NotEmpty(message = "Please select item code")
	private String itemCode;
	@NotNull
	@NotEmpty(message = "Please enter description")
	private String description;
	private String swsUOM;
	private String consQty;
	private String consAmt;
	private String delQty;
	private String delAmt;
	private String totalQty;
	private String  totalAmt;
	public int getSwsId() {
		return swsId;
	}
	public void setSwsId(int swsId) {
		this.swsId = swsId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSwsUOM() {
		return swsUOM;
	}
	public void setSwsUOM(String swsUOM) {
		this.swsUOM = swsUOM;
	}
	public String getConsQty() {
		return consQty;
	}
	public void setConsQty(String consQty) {
		this.consQty = consQty;
	}
	public String getConsAmt() {
		return consAmt;
	}
	public void setConsAmt(String consAmt) {
		this.consAmt = consAmt;
	}
	public String getDelQty() {
		return delQty;
	}
	public void setDelQty(String delQty) {
		this.delQty = delQty;
	}
	public String getDelAmt() {
		return delAmt;
	}
	public void setDelAmt(String delAmt) {
		this.delAmt = delAmt;
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
