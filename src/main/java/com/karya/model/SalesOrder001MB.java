package com.karya.model;

import java.io.Serializable;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;

@Entity
@Table(name="salesorder001mb")
public class SalesOrder001MB implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Sorder")
	private int salesId;
	
	
	@Column(name="Customername")
	private String customerName;
	
	@Column(name="Sorderdate")
	private String orderDate;
	
	@Column(name="Sdeliverydate")
	private String deliveryDate;
	
	@Column(name="Cpurchaseorder")
	private String purchaseOrder;
	
	@Column(name="Statusname")
	private String statusName;
	
	@ManyToOne
	@JoinColumn(name="itemid")
	private Itemdt001MB itemdt001MB;
	
	@ManyToOne
	@JoinColumn(name="orderid")
	private Order001MB order001MB;
	
	@Column(name="Itemcode")
	private String itemCode;
	
	@Column(name="Ordername")
	private String orderName;
	

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
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

	public Itemdt001MB getItemdt001MB() {
		return itemdt001MB;
	}

	public void setItemdt001MB(Itemdt001MB itemdt001mb) {
		itemdt001MB = itemdt001mb;
	}

	public Order001MB getOrder001MB() {
		return order001MB;
	}

	public void setOrder001MB(Order001MB order001mb) {
		order001MB = order001mb;
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
	
	
	@Override
	public String toString(){
		return "SalesOrder001MB [salesId=" + salesId + ",customerName=" + customerName+ ",orderDate=" +orderDate+ ",deliveryDate" +deliveryDate+
				",purchaseOrder=" +purchaseOrder+ ",statusName=" +statusName+ ",itemCode=" + itemCode + ",orderName=" +orderName+ "]";
	}
	
	
}
