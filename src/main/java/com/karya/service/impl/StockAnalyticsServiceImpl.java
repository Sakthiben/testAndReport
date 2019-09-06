package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockAnalyticsDao;
import com.karya.model.Appraisal001MB;
import com.karya.model.DeliveryNoteTrend001MB;
import com.karya.model.PURecptTrend001MB;
import com.karya.service.IStockAnalyticsService;

@Service("stockanalyticsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockAnalyticsServiceImpl implements IStockAnalyticsService{
	
	@Autowired
	private IStockAnalyticsDao stockanlyticsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void adddelnotetrends(DeliveryNoteTrend001MB deliverynotetrend001MB) {
		stockanlyticsDao.adddelnotetrends(deliverynotetrend001MB);
	}
	
	public List<DeliveryNoteTrend001MB> listdelnotetrends() {
		return stockanlyticsDao.listdelnotetrends();
	}

	public DeliveryNoteTrend001MB getdelnotetrends(int dntrendId) {
		return stockanlyticsDao.getdelnotetrends(dntrendId);
	}
	
	public void deletedelnotetrends(int dntrendId) {
		stockanlyticsDao.deletedelnotetrends(dntrendId);
	}
	
	//Purchase Receipt
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpurecpttrend(PURecptTrend001MB purecpttrend001MB) {
		stockanlyticsDao.addpurecpttrend(purecpttrend001MB);
	}
	
	public List<PURecptTrend001MB> listpurecpttrend() {
		return stockanlyticsDao.listpurecpttrend();
	}

	public PURecptTrend001MB getpurecpttrend(int putrendId) {
		return stockanlyticsDao.getpurecpttrend(putrendId);
	}
	
	public void deletepurecpttrend(int putrendId) {
		stockanlyticsDao.deletepurecpttrend(putrendId);
	}
	
	

}
