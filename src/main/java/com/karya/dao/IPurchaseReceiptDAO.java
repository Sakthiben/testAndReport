package com.karya.dao;

import java.util.List;

import com.karya.model.Purchase001MB;


public interface IPurchaseReceiptDAO {
	
	
	  public List<Purchase001MB> listpurchases();
	  
	  public void addpurchase(Purchase001MB purchase);
	  
	  public  Purchase001MB getpurchasedetails(int id);
	  
	  public void deletepurchasedetails(int id);
	  
	 	
}
