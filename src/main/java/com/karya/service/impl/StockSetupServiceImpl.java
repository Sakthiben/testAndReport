package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockSetupDao;
import com.karya.model.Brand001MB;
import com.karya.model.StockSettings001MB;
import com.karya.model.UnitofMeasures001MB;
import com.karya.model.Warehouse001MB;
import com.karya.service.IStockSetupService;

@Service("stocksetupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockSetupServiceImpl implements IStockSetupService{
	
	@Autowired
	private IStockSetupDao stocksetupDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstocksettings(StockSettings001MB stocksettings001MB) {
		stocksetupDao.addstocksettings(stocksettings001MB);
	}
	
	public List<StockSettings001MB> liststocksettings() {
		return stocksetupDao.liststocksettings();
	}

	public StockSettings001MB getstocksettings(int setId) {
		return stocksetupDao.getstocksettings(setId);
	}
	
	public void deletestocksettings(int setId) {
		stocksetupDao.deletestocksettings(setId);
	}
	
	//Warehouse
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addwarehouse(Warehouse001MB warehouse001MB) {
		stocksetupDao.addwarehouse(warehouse001MB);
	}
	
	public List<Warehouse001MB> listwarehouse() {
		return stocksetupDao.listwarehouse();
	}

	public Warehouse001MB getwarehouse(int whId) {
		return stocksetupDao.getwarehouse(whId);
	}
	
	public void deletewarehouse(int whId) {
		stocksetupDao.deletewarehouse(whId);
	}
	
	//Brand
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbrand(Brand001MB brand001MB) {
		stocksetupDao.addbrand(brand001MB);
	}
	
	public List<Brand001MB> listbrand() {
		return stocksetupDao.listbrand();
	}

	public Brand001MB getbrand(int brandId) {
		return stocksetupDao.getbrand(brandId);
	}
	
	public void deletebrand(int brandId) {
		stocksetupDao.deletebrand(brandId);
	}
	
	//Unit of measures
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addunitofmeasure(UnitofMeasures001MB unitofmeasure001MB) {
		stocksetupDao.addunitofmeasure(unitofmeasure001MB);
	}
	
	public List<UnitofMeasures001MB> listunitofmeasure() {
		return stocksetupDao.listunitofmeasure();
	}

	public UnitofMeasures001MB getunitofmeasure(int unitId) {
		return stocksetupDao.getunitofmeasure(unitId);
	}
	
	public void deleteunitofmeasure(int unitId) {
		stocksetupDao.deleteunitofmeasure(unitId);
	}
	
	
	
	
	

}
