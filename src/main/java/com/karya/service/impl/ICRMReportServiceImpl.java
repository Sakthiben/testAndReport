package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMReportsDao;
import com.karya.model.CrmMinTimeResp001MB;
import com.karya.model.InactiveCust001MB;
import com.karya.model.LeadDetail001MB;
import com.karya.service.ICRMReportService;

@Service("crmreportService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ICRMReportServiceImpl implements ICRMReportService{
	
	@Autowired
	private ICRMReportsDao crmreportsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addmintimeresp(CrmMinTimeResp001MB crmmintimeresp001MB) {
		crmreportsDao.addmintimeresp(crmmintimeresp001MB);
	}
	
	public List<CrmMinTimeResp001MB> listmintimeresp() {
		return crmreportsDao.listmintimeresp();
	}

	public CrmMinTimeResp001MB getmintimeresp(int mrpId) {
		return crmreportsDao.getmintimeresp(mrpId);
	}
	
	public void deletemintimeresp(int mrpId) {
		crmreportsDao.deletemintimeresp(mrpId);
	}
	
	//Lead Details
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addleaddetail(LeadDetail001MB leadetail001MB) {
		crmreportsDao.addleaddetail(leadetail001MB);
	}
	
	public List<LeadDetail001MB> listleaddetail() {
		return crmreportsDao.listleaddetail();
	}

	public LeadDetail001MB getleaddetail(int leadId) {
		return crmreportsDao.getleaddetail(leadId);
	}
	
	public void deleteleaddetail(int leadId) {
		crmreportsDao.deleteleaddetail(leadId);
	}
	
	//Inactive Customer
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addinactivecust(InactiveCust001MB inactivecust001MB) {
		crmreportsDao.addinactivecust(inactivecust001MB);
	}
	
	public List<InactiveCust001MB> listinactivecust() {
		return crmreportsDao.listinactivecust();
	}

	public InactiveCust001MB getinactivecust(int inactcustId) {
		return crmreportsDao.getinactivecust(inactcustId);
	}
	
	public void deleteinactivecust(int inactcustId) {
		crmreportsDao.deleteinactivecust(inactcustId);
	}
	
	
	
	

}
