package com.karya.service;

import java.util.List;

import com.karya.model.StkRepAgeing001MB;
import com.karya.model.StkRepLedger001MB;
import com.karya.model.StkRepProjected001MB;
import com.karya.model.StockRepBalance001MB;

public interface IStockReportService {
	
	public void addstkrepledger(StkRepLedger001MB stkrepledger001MB);

	public List<StkRepLedger001MB> liststkrepledger();
	
	public StkRepLedger001MB getstkrepledger(int stledId);
	
	public void deletestkrepledger(int stledId);
	
	//Stock Report Balance
	
	public void addstkrepbalance(StockRepBalance001MB stkrepbalance001MB);

	public List<StockRepBalance001MB> liststkrepbalance();
	
	public StockRepBalance001MB getstkrepbalance(int stbalId);
	
	public void deletestkrepbalance(int stbalId);
	
	//Stock Report Projected
	
	public void addstkrepprojected(StkRepProjected001MB stkrepprojected001MB);

	public List<StkRepProjected001MB> liststkrepprojected();
	
	public StkRepProjected001MB getstkrepprojected(int stprojId);
	
	public void deletestkrepprojected(int stprojId);
	
	//Stock Ageing
	
	public void addstkrepageing(StkRepAgeing001MB stkrepageing001MB);

	public List<StkRepAgeing001MB> liststkrepageing();
	
	public StkRepAgeing001MB getstkrepageing(int stageId);
	
	public void deletestkrepageing(int stageId);
	
	

}
