package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SalesOrderBean {
	
	private Integer salesId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the customer name")
	private String customerName;
	
	@NotNull
	 @NotEmpty(message = "Please mention order date")
	private String orderDate;
	
	@NotNull
	 @NotEmpty(message = "Please mention delivery date")
	private String deliveryDate;
	
	@NotNull
	 @NotEmpty(message = "Please enter the purchase order")
	
	private String purchaseOrder;
	
	@NotNull
	 @NotEmpty(message = "Please enter the status name")
	
	private String statusName;
	private int orderid;
	private int itemid;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item")
	
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the order")
	
	private String orderName;
	
	public Integer getSalesId() {
		return salesId;
	}
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public SalesOrderBean() {
		salesId=0;
		customerName="";
		orderDate="";
		deliveryDate="";
		purchaseOrder="";
		statusName="";
		orderid=0;
		itemid=0;
		itemCode="";
		orderName="";
	}
	public SalesOrderBean(Integer salesId,String customerName,String orderDate,
						String deliveryDate,String purchaseOrder,String statusName,int orderid,int itemid,String itemCode,String orderName) {
		this.salesId=salesId;
		this.customerName=customerName;
		this.orderDate=orderDate;
		this.deliveryDate=deliveryDate;
		this.purchaseOrder=purchaseOrder;
		this.statusName=statusName;
		this.orderid=orderid;
		this.itemid=itemid;
		this.itemCode=itemCode;
		this.orderName=orderName;
		
	}
}