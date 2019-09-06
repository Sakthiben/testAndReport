package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProdOrderDao;
import com.karya.model.ProdOrder001MB;
import com.karya.model.ProdPlanning001MB;
import com.karya.model.ProdStockEntry001MB;
import com.karya.model.ProdTimeSheet001MB;
import com.karya.service.IProdOrderService;

@Service("prodorderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ProdOrderServiceImpl implements IProdOrderService {
	
	@Autowired
	private IProdOrderDao prodorderDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProdorder(ProdOrder001MB prodorder001MB) {
		prodorderDao.addProdorder(prodorder001MB);
	}
	
	public List<ProdOrder001MB> listprodorder() {
		return prodorderDao.listprodorder();
	}

	public ProdOrder001MB getprodorder(int prId) {
		return prodorderDao.getprodorder(prId);
	}
	
	public void deleteprodorder(int prId) {
		prodorderDao.deleteprodorder(prId);
	}

	//Product Planning
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProdplanning(ProdPlanning001MB prodplanning001MB) {
		prodorderDao.addProdplanning(prodplanning001MB);
	}
	
	public List<ProdPlanning001MB> listprodplanning() {
		return prodorderDao.listprodplanning();
	}

	public ProdPlanning001MB getprodplanning(int prplanId) {
		return prodorderDao.getprodplanning(prplanId);
	}
	
	public void deleteprodplanning(int prplanId) {
		prodorderDao.deleteprodplanning(prplanId);
	}
	
	//product Stock Entry
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProdstockentry(ProdStockEntry001MB prodstockentry001MB) {
		prodorderDao.addProdstockentry(prodstockentry001MB);
	}
	
	public List<ProdStockEntry001MB> listprodstockentry() {
		return prodorderDao.listprodstockentry();
	}

	public ProdStockEntry001MB getprodstockentry(int prstockId) {
		return prodorderDao.getprodstockentry(prstockId);
	}
	
	public void deleteprodstockentry(int prstockId) {
		prodorderDao.deleteprodstockentry(prstockId);
	}
	
	//product Stock Entry
	
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public void addProdtimesheet(ProdTimeSheet001MB prodtimesheet001MB) {
			prodorderDao.addProdtimesheet(prodtimesheet001MB);
		}
		
		public List<ProdTimeSheet001MB> listprodtimesheet() {
			return prodorderDao.listprodtimesheet();
		}

		public ProdTimeSheet001MB getprodtimesheet(int prtId) {
			return prodorderDao.getprodtimesheet(prtId);
		}
		
		public void deleteprodtimesheet(int prtId) {
			prodorderDao.deleteprodtimesheet(prtId);
		}
	
	
}
