package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockToolsDao;
import com.karya.model.InstallationNote001MB;
import com.karya.model.LandCostCoucher001MB;
import com.karya.model.PackingSlip001MB;
import com.karya.model.StockReconcile001MB;
import com.karya.service.IStockToolsService;

@Service("stocktoolsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockToolsServiceImpl implements IStockToolsService{
	
	@Autowired
	private IStockToolsDao stocktoolsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addinstallnote(InstallationNote001MB installationnote001MB) {
		stocktoolsDao.addinstallnote(installationnote001MB);
	}
	
	public List<InstallationNote001MB> listinstallnote() {
		return stocktoolsDao.listinstallnote();
	}

	public InstallationNote001MB getinstallnote(int instId) {
		return stocktoolsDao.getinstallnote(instId);
	}
	
	public void deleteinstallnote(int instId) {
		stocktoolsDao.deleteinstallnote(instId);
	}
	
	//Stock Reconcile
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstockreconcile(StockReconcile001MB stockreconcile001MB) {
		stocktoolsDao.addstockreconcile(stockreconcile001MB);
	}
	
	public List<StockReconcile001MB> liststockreconcile() {
		return stocktoolsDao.liststockreconcile();
	}

	public StockReconcile001MB getstockreconcile(int stkrecId) {
		return stocktoolsDao.getstockreconcile(stkrecId);
	}
	
	public void deletestockreconcile(int stkrecId) {
		stocktoolsDao.deletestockreconcile(stkrecId);
	}
	
	//Packing slip
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpackingslip(PackingSlip001MB packingslip001MB) {
		stocktoolsDao.addpackingslip(packingslip001MB);
	}
	
	public List<PackingSlip001MB> listpackingslip() {
		return stocktoolsDao.listpackingslip();
	}

	public PackingSlip001MB getpackingslip(int psId) {
		return stocktoolsDao.getpackingslip(psId);
	}
	
	public void deletepackingslip(int psId) {
		stocktoolsDao.deletepackingslip(psId);
	}
	
	//Land cost voucher
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addlandcostvoucher(LandCostCoucher001MB landcostvoucher001MB) {
		stocktoolsDao.addlandcostvoucher(landcostvoucher001MB);
	}
	
	public List<LandCostCoucher001MB> listlandcostvoucher() {
		return stocktoolsDao.listlandcostvoucher();
	}

	public LandCostCoucher001MB getlandcostvoucher(int vouchId) {
		return stocktoolsDao.getlandcostvoucher(vouchId);
	}
	
	public void deletelandcostvoucher(int vouchId) {
		stocktoolsDao.deletelandcostvoucher(vouchId);
	}
	
	
	
	

}
