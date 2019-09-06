package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMspDao;
import com.karya.model.CrmOppo001MB;
import com.karya.model.CrmspContact001MB;
import com.karya.model.CrmspCust001MB;
import com.karya.model.CrmspLead001MB;
import com.karya.service.ICRMspService;

@Service("crmspService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CRMspServiceImpl implements ICRMspService{
	@Autowired
	private ICRMspDao crmspDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcrmsplead(CrmspLead001MB crmspleadl001MB) {
		crmspDao.addcrmsplead(crmspleadl001MB);
	}
	
	public List<CrmspLead001MB> listcrmsplead() {
		return crmspDao.listcrmsplead();
	}

	public CrmspLead001MB getcrmsplead(int slineId) {
		return crmspDao.getcrmsplead(slineId);
	}
	
	public void deletecrmsplead(int slineId) {
		crmspDao.deletecrmsplead(slineId);
	}
	
	//CRM Contact
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcrmspcontact(CrmspContact001MB crmspcontactl001MB) {
		crmspDao.addcrmspcontact(crmspcontactl001MB);
	}
	
	public List<CrmspContact001MB> listcrmspcontact() {
		return crmspDao.listcrmspcontact();
	}

	public CrmspContact001MB getcrmspcontact(int contId) {
		return crmspDao.getcrmspcontact(contId);
	}
	
	public void deletecrmspcontact(int contId) {
		crmspDao.deletecrmspcontact(contId);
	}
	
	//CRM Oppo
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcrmoppo(CrmOppo001MB crmoppol001MB) {
		crmspDao.addcrmoppo(crmoppol001MB);
	}
	
	public List<CrmOppo001MB> listcrmoppo() {
		return crmspDao.listcrmoppo();
	}

	public CrmOppo001MB getcrmoppo(int oppId) {
		return crmspDao.getcrmoppo(oppId);
	}
	
	public void deletecrmoppo(int oppId) {
		crmspDao.deletecrmoppo(oppId);
	}
	
	//CRM Customer
	
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public void addcrmcust(CrmspCust001MB crmcust001MB) {
			crmspDao.addcrmcust(crmcust001MB);
		}
		
		public List<CrmspCust001MB> listcrmcust() {
			return crmspDao.listcrmcust();
		}

		public CrmspCust001MB getcrmcust(int custId) {
			return crmspDao.getcrmcust(custId);
		}
		
		public void deletecrmcust(int custId) {
			crmspDao.deletecrmcust(custId);
		}
		
	
	

}
