package com.karya.dao;

import java.util.List;

import com.karya.model.StockTransDelivery001MB;
import com.karya.model.StockTransEntry001MB;
import com.karya.model.StockTransPurRecpt001MB;

public interface IStockTransactionDao {
	
	public void addstocktransentry(StockTransEntry001MB stocktransentry001MB);

	public List<StockTransEntry001MB> liststocktransentry();
	
	public StockTransEntry001MB getstocktransentry(int stentid);
	
	public void deletestocktransentry(int stentid);
	
	//Stock Delivery Note

		public void addstocktransdelivery(StockTransDelivery001MB stocktransdelivery001MB);
		
		public List<StockTransDelivery001MB> liststocktransdelivery();
		
		public StockTransDelivery001MB getstocktransdelivery(int stdelId);
		
		public void deletestocktransdelivery(int stdelId);
		
	//Stock trans Purchase Receipt
		
		public void addstocktranspurreceipt(StockTransPurRecpt001MB stocktranspurrecpt001MB);
		
		public List<StockTransPurRecpt001MB> liststocktranspurreceipt();
		
		public StockTransPurRecpt001MB getstocktranspurreceipt(int stpurtId);
		
		public void deletestocktranspurreceipt(int stpurtId);

}

