package com.karya.bean;
import javax.validation.constraints.NotNull; 
import org.hibernate.validator.constraints.NotEmpty; 
public class ProductBundleBean {
	
	private int pbundId;
	@NotNull
	 @NotEmpty(message = "Please select item code")
	private String itemCode;
	@NotNull
	 @NotEmpty(message = "Please enter child item")
	private String childItem;
	@NotNull
	 @NotEmpty(message = "Please enter quantity")
	private String quantity;
	@NotNull
	 @NotEmpty(message = "Please enter description")
	private String description;
	public int getPbundId() {
		return pbundId;
	}
	public void setPbundId(int pbundId) {
		this.pbundId = pbundId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getChildItem() {
		return childItem;
	}
	public void setChildItem(String childItem) {
		this.childItem = childItem;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
