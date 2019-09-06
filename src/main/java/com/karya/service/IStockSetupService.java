package com.karya.service;

import java.util.List;

import com.karya.model.Brand001MB;
import com.karya.model.StockSettings001MB;
import com.karya.model.UnitofMeasures001MB;
import com.karya.model.Warehouse001MB;

public interface IStockSetupService {
	
	public void addstocksettings(StockSettings001MB stocksettings001MB);

	public List<StockSettings001MB> liststocksettings();
	
	public StockSettings001MB getstocksettings(int setId);
	
	public void deletestocksettings(int setId);
	
	//Warehouse
	
	public void addwarehouse(Warehouse001MB warehouse001MB);

	public List<Warehouse001MB> listwarehouse();
	
	public Warehouse001MB getwarehouse(int whId);
	
	public void deletewarehouse(int whId);
	
	//Brand
	
	public void addbrand(Brand001MB brand001MB);

	public List<Brand001MB> listbrand();
	
	public Brand001MB getbrand(int brandId);
	
	public void deletebrand(int brandId);
	
	//Unit of measure
	
	public void addunitofmeasure(UnitofMeasures001MB unitofmeasure001MB);

	public List<UnitofMeasures001MB> listunitofmeasure();
	
	public UnitofMeasures001MB getunitofmeasure(int unitId);
	
	public void deleteunitofmeasure(int unitId);
	
	
	
	

}
