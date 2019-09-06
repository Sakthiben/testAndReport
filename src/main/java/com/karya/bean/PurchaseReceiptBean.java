package com.karya.bean;

public class PurchaseReceiptBean {
	
  private int id;
  private String supplier;
  private String Date;
  private String supplieraddress;
  private int grandtotal;
  private String status;

  
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSupplier() {
	return supplier;
}
public void setSupplier(String supplier) {
	this.supplier = supplier;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getSupplieraddress() {
	return supplieraddress;
}
public void setSupplieraddress(String supplieraddress) {
	this.supplieraddress = supplieraddress;
}
public int getGrandtotal() {
	return grandtotal;
}
public void setGrandtotal(int grandtotal) {
	this.grandtotal = grandtotal;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
	
}