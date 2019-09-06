package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ISupplierDao;
import com.karya.model.Supplier001MB;
import com.karya.model.SupplierStatus001MB;
import com.karya.model.SupplierType001MB;
import com.karya.service.ISupplierService;

@Service("supplierService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class SupplierServiceImpl implements ISupplierService{
	@Autowired
	private ISupplierDao supplierDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsupplier(Supplier001MB supplier001MB) {
		supplierDao.addsupplier(supplier001MB);
	}
	
	public List<Supplier001MB> listsupplier() {
		return supplierDao.listsupplier();
	}

	public Supplier001MB getsupplier(int supId) {
		return supplierDao.getsupplier(supId);
	}
	
	public void deletesupplier(int supId) {
		supplierDao.deletesupplier(supId);
	}
	
	//Supplier Type
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsuppliertype(SupplierType001MB suppliertype001MB) {
		supplierDao.addsuppliertype(suppliertype001MB);
	}
	
	public List<SupplierType001MB> listsuppliertype() {
		return supplierDao.listsuppliertype();
	}

	public SupplierType001MB getsuppliertype(int sutypeId) {
		return supplierDao.getsuppliertype(sutypeId);
	}
	
	public void deletesuppliertype(int sutypeId) {
		supplierDao.deletesuppliertype(sutypeId);
	}
	
	//Supplier status
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsupplierstat(SupplierStatus001MB supplierstat001MB) {
		supplierDao.addsupplierstat(supplierstat001MB);
	}
	
	public List<SupplierStatus001MB> listsupplierstat() {
		return supplierDao.listsupplierstat();
	}

	public SupplierStatus001MB getsupplierstat(int sustatusId) {
		return supplierDao.getsupplierstat(sustatusId);
	}
	
	public void deletesupplierstat(int sustatusId) {
		supplierDao.deletesupplierstat(sustatusId);
	}
	
	
	
	
	

}
