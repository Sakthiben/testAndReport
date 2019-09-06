package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBOMDao;
import com.karya.model.ItemStatus001MB;
import com.karya.model.OperationBOM001MB;
import com.karya.model.WorkStation001MB;
import com.karya.service.IBOMService;

@Service("bomService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class BOMServiceImpl implements IBOMService{
	
	@Autowired
	private IBOMDao bomDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemst(ItemStatus001MB itemstatus001MB) {
		bomDao.additemst(itemstatus001MB);
	}
	
	public List<ItemStatus001MB> listitemst() {
		return bomDao.listitemst();
	}

	public ItemStatus001MB getitemst(int itemstId) {
		return bomDao.getitemst(itemstId);
	}
	
	public void deleteitemst(int itemstId) {
		bomDao.deleteitemst(itemstId);
	}
	
	//Workstation Service Impl
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addworkstn(WorkStation001MB workstation001MB) {
		bomDao.addworkstn(workstation001MB);
	}
	
	public List<WorkStation001MB> listworkstn() {
		return bomDao.listworkstn();
	}

	public WorkStation001MB getworkstn(int workstId) {
		return bomDao.getworkstn(workstId);
	}
	
	public void deleteworkstn(int workstId) {
		bomDao.deleteworkstn(workstId);
	}
	
	//Operation Impl
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addoperation(OperationBOM001MB operationbom001MB) {
		bomDao.addoperation(operationbom001MB);
	}
	
	public List<OperationBOM001MB> listoperation() {
		return bomDao.listoperation();
	}

	public OperationBOM001MB getoperation(int opId) {
		return bomDao.getoperation(opId);
	}
	
	public void deleteoperation(int opId) {
		bomDao.deleteoperation(opId);
	}
	
	
	
	
	

}
