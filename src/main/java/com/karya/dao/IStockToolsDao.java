package com.karya.dao;

import java.util.List;

import com.karya.model.InstallationNote001MB;
import com.karya.model.LandCostCoucher001MB;
import com.karya.model.PackingSlip001MB;
import com.karya.model.StockReconcile001MB;

public interface IStockToolsDao {
	
	public void addinstallnote(InstallationNote001MB installationnote001MB);

	public List<InstallationNote001MB> listinstallnote();
	
	public InstallationNote001MB getinstallnote(int instId);
	
	public void deleteinstallnote(int instId);
	
	//Stock reconcile
	
	public void addstockreconcile(StockReconcile001MB stockreconcile001MB);

	public List<StockReconcile001MB> liststockreconcile();
	
	public StockReconcile001MB getstockreconcile(int stkrecId);
	
	public void deletestockreconcile(int stkrecId);
	
	//Packing Slip
	
	public void addpackingslip(PackingSlip001MB packingslip001MB);

	public List<PackingSlip001MB> listpackingslip();
	
	public PackingSlip001MB getpackingslip(int psId);
	
	public void deletepackingslip(int psId);
	
	//Land COST Voucher
	
	public void addlandcostvoucher(LandCostCoucher001MB landcostvoucher001MB);

	public List<LandCostCoucher001MB> listlandcostvoucher();
	
	public LandCostCoucher001MB getlandcostvoucher(int vouchId);
	
	public void deletelandcostvoucher(int vouchId);
	
	
	
	
	
	

}
