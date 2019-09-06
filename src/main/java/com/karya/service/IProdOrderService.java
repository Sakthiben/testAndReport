package com.karya.service;

import java.util.List;

import com.karya.model.ProdOrder001MB;
import com.karya.model.ProdPlanning001MB;
import com.karya.model.ProdStockEntry001MB;
import com.karya.model.ProdTimeSheet001MB;

public interface IProdOrderService {
	
	public void addProdorder(ProdOrder001MB prodorder001MB);

	public List<ProdOrder001MB> listprodorder();
	
	public ProdOrder001MB getprodorder(int prId);
	
	public void deleteprodorder(int prId);
	
	//Product Planning
	
		public void addProdplanning(ProdPlanning001MB prodplanning001MB);

		public List<ProdPlanning001MB> listprodplanning();
		
		public ProdPlanning001MB getprodplanning(int prplanId);
		
		public void deleteprodplanning(int prplanId);
		
		//Product Stock Entry
		
		public void addProdstockentry(ProdStockEntry001MB prodstockentry001MB);

		public List<ProdStockEntry001MB> listprodstockentry();
			
		public ProdStockEntry001MB getprodstockentry(int prstockId);
			
		public void deleteprodstockentry(int prstockId);
			
		//Product Time Sheet
			
		public void addProdtimesheet(ProdTimeSheet001MB prodtimesheet001MB);

		public List<ProdTimeSheet001MB> listprodtimesheet();
				
		public ProdTimeSheet001MB getprodtimesheet(int prtId);
				
		public void deleteprodtimesheet(int prtId);
			
			


}
