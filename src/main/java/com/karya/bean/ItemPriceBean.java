package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty;

public class ItemPriceBean {
	private int ipId;
	@NotNull
	 @NotEmpty(message = "Please select itemCode")
	private String itemCode;
	@NotNull
	 @NotEmpty(message = "Please select itemGroup")
	private String itemGroup;
	@NotNull
	 @NotEmpty(message = "Please select status")
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIpId() {
		return ipId;
	}
	public void setIpId(int ipId) {
		this.ipId = ipId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	
}
