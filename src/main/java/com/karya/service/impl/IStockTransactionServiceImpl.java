package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockTransactionDao;
import com.karya.model.StockTransDelivery001MB;
import com.karya.model.StockTransEntry001MB;
import com.karya.model.StockTransPurRecpt001MB;
import com.karya.service.IStockTransactionService;

@Service("stocktransactionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IStockTransactionServiceImpl implements IStockTransactionService{
	
	@Autowired
	private IStockTransactionDao stocktransactionDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstocktransentry(StockTransEntry001MB stocktransentry001MB) {
		stocktransactionDao.addstocktransentry(stocktransentry001MB);
	}
	
	public List<StockTransEntry001MB> liststocktransentry() {
		return stocktransactionDao.liststocktransentry();
	}

	public StockTransEntry001MB getstocktransentry(int stentid) {
		return stocktransactionDao.getstocktransentry(stentid);
	}
	
	public void deletestocktransentry(int stentid) {
		stocktransactionDao.deletestocktransentry(stentid);
	}
	
	//Stock trans delivery note
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstocktransdelivery(StockTransDelivery001MB stocktransdelivery001MB) {
		stocktransactionDao.addstocktransdelivery(stocktransdelivery001MB);
	}
	
	public List<StockTransDelivery001MB> liststocktransdelivery() {
		return stocktransactionDao.liststocktransdelivery();
	}

	public StockTransDelivery001MB getstocktransdelivery(int stdelId) {
		return stocktransactionDao.getstocktransdelivery(stdelId);
	}
	
	public void deletestocktransdelivery(int stdelId) {
		stocktransactionDao.deletestocktransdelivery(stdelId);
	}
	
	//Stock Trans Pur Receipt
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addstocktranspurreceipt(StockTransPurRecpt001MB stocktranspurrecpt001MB) {
		stocktransactionDao.addstocktranspurreceipt(stocktranspurrecpt001MB);
	}
	
	public List<StockTransPurRecpt001MB> liststocktranspurreceipt() {
		return stocktransactionDao.liststocktranspurreceipt();
	}

	public StockTransPurRecpt001MB getstocktranspurreceipt(int stpurtId) {
		return stocktransactionDao.getstocktranspurreceipt(stpurtId);
	}
	
	public void deletestocktranspurreceipt(int stpurtId) {
		stocktransactionDao.deletestocktranspurreceipt(stpurtId);
	}
	
	

	
	
}
