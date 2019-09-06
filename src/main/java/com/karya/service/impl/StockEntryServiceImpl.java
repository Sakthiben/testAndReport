package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockEntryDAO;
import com.karya.model.StockEntry001MB;
import com.karya.service.IStockEntryService;


@Service("StockService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockEntryServiceImpl implements IStockEntryService {
	
	@Autowired
	private IStockEntryDAO stockentrydao;
	
	
	public List<StockEntry001MB> liststockentry () {
		
		return stockentrydao.liststockentry();		
		
	}


	@Override
	public void addstock(StockEntry001MB stock) {
		stockentrydao.addstock(stock);
		
	}


	@Override
	public StockEntry001MB getstockdetails(int stockid) {
	
		return stockentrydao.getstockdetails(stockid);
		
	}


	@Override
	public void deletestockdetails(int stockid) {
	
		stockentrydao.deletestockdetails(stockid);
	}
	
	
}

