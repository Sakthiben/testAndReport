package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockReportDao;
import com.karya.model.StkRepAgeing001MB;
import com.karya.model.StkRepLedger001MB;
import com.karya.model.StkRepProjected001MB;
import com.karya.model.StockRepBalance001MB;
import com.karya.service.IStockReportService;

@Service("stockreportService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockReportServiceImpl implements IStockReportService{
	@Autowired
	private IStockReportDao stockreportDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstkrepledger(StkRepLedger001MB stkrepledger001MB) {
		stockreportDao.addstkrepledger(stkrepledger001MB);
	}
	
	public List<StkRepLedger001MB> liststkrepledger() {
		return stockreportDao.liststkrepledger();
	}

	public StkRepLedger001MB getstkrepledger(int stledId) {
		return stockreportDao.getstkrepledger(stledId);
	}
	
	public void deletestkrepledger(int stledId) {
		stockreportDao.deletestkrepledger(stledId);
	}
	
	//Stock Balance
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstkrepbalance(StockRepBalance001MB stkrepbalance001MB) {
		stockreportDao.addstkrepbalance(stkrepbalance001MB);
	}
	
	public List<StockRepBalance001MB> liststkrepbalance() {
		return stockreportDao.liststkrepbalance();
	}

	public StockRepBalance001MB getstkrepbalance(int stbalId) {
		return stockreportDao.getstkrepbalance(stbalId);
	}
	
	public void deletestkrepbalance(int stbalId) {
		stockreportDao.deletestkrepbalance(stbalId);
	}
	
	//Stock Projected
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstkrepprojected(StkRepProjected001MB stkrepprojected001MB) {
		stockreportDao.addstkrepprojected(stkrepprojected001MB);
	}
	
	public List<StkRepProjected001MB> liststkrepprojected() {
		return stockreportDao.liststkrepprojected();
	}

	public StkRepProjected001MB getstkrepprojected(int stprojId) {
		return stockreportDao.getstkrepprojected(stprojId);
	}
	
	public void deletestkrepprojected(int stprojId) {
		stockreportDao.deletestkrepprojected(stprojId);
	}
	
	//Stock ageing
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstkrepageing(StkRepAgeing001MB stkrepageing001MB) {
		stockreportDao.addstkrepageing(stkrepageing001MB);
	}
	
	public List<StkRepAgeing001MB> liststkrepageing() {
		return stockreportDao.liststkrepageing();
	}

	public StkRepAgeing001MB getstkrepageing(int stageId) {
		return stockreportDao.getstkrepageing(stageId);
	}
	
	public void deletestkrepageing(int stageId) {
		stockreportDao.deletestkrepageing(stageId);
	}
	
	
	
	
	
	
	
	
	
	
	

}
