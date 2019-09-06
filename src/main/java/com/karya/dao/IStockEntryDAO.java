package com.karya.dao;

import java.util.List;


import com.karya.model.StockEntry001MB;

public interface IStockEntryDAO {
	
	  public List<StockEntry001MB> liststockentry();
	  
	  public void addstock(StockEntry001MB stock);
	  
	  public StockEntry001MB getstockdetails(int stockid);
	  
	  public void deletestockdetails(int stockid);
	  
	 	
}
