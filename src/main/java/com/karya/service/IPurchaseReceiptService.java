package com.karya.service;

import java.util.List;

import com.karya.model.Purchase001MB;


public interface IPurchaseReceiptService {
	
	public void addpurchase(Purchase001MB purchase);
	
	public List<Purchase001MB> listpurchases();
	
	public Purchase001MB getpurchasedetails(int id);
	
	public void deletepurchasedetails(int id);  
	
}