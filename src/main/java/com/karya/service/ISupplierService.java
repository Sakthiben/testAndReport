package com.karya.service;

import java.util.List;

import com.karya.model.Supplier001MB;
import com.karya.model.SupplierStatus001MB;
import com.karya.model.SupplierType001MB;

public interface ISupplierService {
	
	public void addsupplier(Supplier001MB supplier001MB);

	public List<Supplier001MB> listsupplier();
	
	public Supplier001MB getsupplier(int supId);
	
	public void deletesupplier(int supId);
	
	//Supplier Type
	
	public void addsuppliertype(SupplierType001MB suppliertype001MB);

	public List<SupplierType001MB> listsuppliertype();
	
	public SupplierType001MB getsuppliertype(int sutypeId);
	
	public void deletesuppliertype(int sutypeId);
	
	//Supplier Status
	
	public void addsupplierstat(SupplierStatus001MB supplierstat001MB);

	public List<SupplierStatus001MB> listsupplierstat();
	
	public SupplierStatus001MB getsupplierstat(int sustatusId);
	
	public void deletesupplierstat(int sustatusId);
	
	

}
