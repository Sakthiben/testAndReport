package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IPurchaseDao;
import com.karya.model.Appraisal001MB;
import com.karya.model.PRMatReq001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PRQuotReq001MB;
import com.karya.model.PRSuQuotReq001MB;
import com.karya.service.IPurchaseService;

@Service("purchaseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PurchaseServiceImpl implements IPurchaseService{
	
	@Autowired
	private IPurchaseDao pruchaseDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprmatreq(PRMatReq001MB prmatreq1MB) {
		pruchaseDao.addprmatreq(prmatreq1MB);
	}
	
	public List<PRMatReq001MB> listprmatreq() {
		return pruchaseDao.listprmatreq();
	}

	public PRMatReq001MB getprmatreq(int pmrId) {
		return pruchaseDao.getprmatreq(pmrId);
	}
	
	public void deleteprmatreq(int pmrId) {
		pruchaseDao.deleteprmatreq(pmrId);
	}
	
	//req quot
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprquotreq(PRQuotReq001MB prquotreq1MB) {
		pruchaseDao.addprquotreq(prquotreq1MB);
	}
	
	public List<PRQuotReq001MB> listprquotreq() {
		return pruchaseDao.listprquotreq();
	}

	public PRQuotReq001MB getprquotreq(int prqId) {
		return pruchaseDao.getprquotreq(prqId);
	}
	
	public void deleteprquotreq(int prqId) {
		pruchaseDao.deleteprquotreq(prqId);
	}
	
	//Supplier quot
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprsuquotreq(PRSuQuotReq001MB prsuquotreq1MB) {
		pruchaseDao.addprsuquotreq(prsuquotreq1MB);
	}
	
	public List<PRSuQuotReq001MB> listprsuquotreq() {
		return pruchaseDao.listprsuquotreq();
	}

	public PRSuQuotReq001MB getprsuquotreq(int prsrId) {
		return pruchaseDao.getprsuquotreq(prsrId);
	}
	
	public void deleteprsuquotreq(int prsrId) {
		pruchaseDao.deleteprsuquotreq(prsrId);
	}
	
	//purchase quot
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprpurorder(PRPurOrd001MB prpurorder1MB) {
		pruchaseDao.addprpurorder(prpurorder1MB);
	}
	
	public List<PRPurOrd001MB> listprpurorder() {
		return pruchaseDao.listprpurorder();
	}

	public PRPurOrd001MB getprpurorder(int proId) {
		return pruchaseDao.getprpurorder(proId);
	}
	
	public void deleteprpurorder(int proId) {
		pruchaseDao.deleteprpurorder(proId);
	}
	
	
	
	
	

}
