package com.karya.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order001mb")
public class Order001MB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderid")
	private int orderId;
	
	@Column(name="Ordername")
	private String orderName;
	
	@OneToMany(mappedBy="order001MB")
	private Set<SalesOrder001MB> salesOrder001MB;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Set<SalesOrder001MB> getSalesOrder001MB() {
		return salesOrder001MB;
	}

	public void setSalesOrder001MB(Set<SalesOrder001MB> salesOrder001MB) {
		this.salesOrder001MB = salesOrder001MB;
	}

}