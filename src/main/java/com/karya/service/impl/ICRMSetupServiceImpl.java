package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMSetupDao;
import com.karya.model.Communication001MB;
import com.karya.model.CustomerGroup001MB;
import com.karya.model.Territory001MB;
import com.karya.service.ICRMSetupService;

@Service("crmsetupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ICRMSetupServiceImpl implements ICRMSetupService{
	
	@Autowired
	private ICRMSetupDao crmsetupDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcommunication(Communication001MB communication001MB) {
		crmsetupDao.addcommunication(communication001MB);
	}
	
	public List<Communication001MB> listcommunication() {
		return crmsetupDao.listcommunication();
	}

	public Communication001MB getcommunication(int commId) {
		return crmsetupDao.getcommunication(commId);
	}
	
	public void deletecommunication(int commId) {
		crmsetupDao.deletecommunication(commId);
	}
	
	//Customer Group
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcustgroup(CustomerGroup001MB custGroup001MB) {
		crmsetupDao.addcustgroup(custGroup001MB);
	}
	
	public List<CustomerGroup001MB> listcustgroup() {
		return crmsetupDao.listcustgroup();
	}

	public CustomerGroup001MB getcustgroup(int cugrpId) {
		return crmsetupDao.getcustgroup(cugrpId);
	}
	
	public void deletecustgroup(int cugrpId) {
		crmsetupDao.deletecustgroup(cugrpId);
	}
	
	//Territory
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addterritory(Territory001MB territory001MB) {
		crmsetupDao.addterritory(territory001MB);
	}
	
	public List<Territory001MB> listterritory() {
		return crmsetupDao.listterritory();
	}

	public Territory001MB getterritory(int terId) {
		return crmsetupDao.getterritory(terId);
	}
	
	public void deleteterritory(int terId) {
		crmsetupDao.deleteterritory(terId);
	}
	
	
	
	
	
	

}
