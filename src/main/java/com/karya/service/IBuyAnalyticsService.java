package com.karya.service;

import java.util.List;

import com.karya.model.PuOrderTrend001MB;
import com.karya.model.PurchaseAnalytics001MB;
import com.karya.model.SupplierWiseAnalytics001MB;

public interface IBuyAnalyticsService {
	
	public void addpuanalytics(PurchaseAnalytics001MB purchaseanalytics001MB);

	public List<PurchaseAnalytics001MB> listpuanalytics();
	
	public PurchaseAnalytics001MB getpuanalytics(int puansId);
	
	public void deletepuanalytics(int puansId);
	
	//PuOrderTrend
	public void addpuordtrend(PuOrderTrend001MB puordertrend001MB);

	public List<PuOrderTrend001MB> listpuordtrend();
	
	public PuOrderTrend001MB getpuordtrend(int ptrId);
	
	public void deletepuordtrend(int ptrId);
	
	//Supplier Wise Analytics
	public void addswsanalytics(SupplierWiseAnalytics001MB supplierwiseanalytics001MB);

	public List<SupplierWiseAnalytics001MB> listswsanalytics();
	
	public SupplierWiseAnalytics001MB getswsanalytics(int swsId);
	
	public void deleteswsanalytics(int swsId);
	
	
	

}
