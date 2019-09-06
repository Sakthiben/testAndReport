package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBuyAnalyticsDao;
import com.karya.model.PuOrderTrend001MB;
import com.karya.model.PurchaseAnalytics001MB;
import com.karya.model.SupplierWiseAnalytics001MB;
import com.karya.service.IBuyAnalyticsService;

@Service("buyanalyticsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class BuyAnalyticsServiceImpl implements IBuyAnalyticsService{
	
	@Autowired
	private IBuyAnalyticsDao buyanalyticsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpuanalytics(PurchaseAnalytics001MB purchaseanalytics001MB) {
		buyanalyticsDao.addpuanalytics(purchaseanalytics001MB);
	}
	
	public List<PurchaseAnalytics001MB> listpuanalytics() {
		return buyanalyticsDao.listpuanalytics();
	}

	public PurchaseAnalytics001MB getpuanalytics(int puansId) {
		return buyanalyticsDao.getpuanalytics(puansId);
	}
	
	public void deletepuanalytics(int puansId) {
		buyanalyticsDao.deletepuanalytics(puansId);
	}
	
	//PU order trend
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpuordtrend(PuOrderTrend001MB puordertrend001MB) {
		buyanalyticsDao.addpuordtrend(puordertrend001MB);
	}
	
	public List<PuOrderTrend001MB> listpuordtrend() {
		return buyanalyticsDao.listpuordtrend();
	}

	public PuOrderTrend001MB getpuordtrend(int ptrId) {
		return buyanalyticsDao.getpuordtrend(ptrId);
	}
	
	public void deletepuordtrend(int ptrId) {
		buyanalyticsDao.deletepuordtrend(ptrId);
	}
	
	//supplier wise analytics
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addswsanalytics(SupplierWiseAnalytics001MB supplierwiseanalytics001MB) {
		buyanalyticsDao.addswsanalytics(supplierwiseanalytics001MB);
	}
	
	public List<SupplierWiseAnalytics001MB> listswsanalytics() {
		return buyanalyticsDao.listswsanalytics();
	}

	public SupplierWiseAnalytics001MB getswsanalytics(int swsId) {
		return buyanalyticsDao.getswsanalytics(swsId);
	}
	
	public void deleteswsanalytics(int swsId) {
		buyanalyticsDao.deleteswsanalytics(swsId);
	}
	
	
	
	
	
	

}
