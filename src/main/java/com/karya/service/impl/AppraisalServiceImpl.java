package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAppraisalDao;
import com.karya.model.Appraisal001MB;
import com.karya.model.AppraisalTempModel001MB;
import com.karya.service.IAppraisalService;

@Service("appraisalService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AppraisalServiceImpl implements IAppraisalService {
	
	@Autowired
	private IAppraisalDao appraisalDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addappraisal(Appraisal001MB appraisal001MB) {
		appraisalDao.addappraisal(appraisal001MB);
	}
	
	public List<Appraisal001MB> listappraisal() {
		return appraisalDao.listappraisal();
	}

	public Appraisal001MB getappraisal(int apprId) {
		return appraisalDao.getappraisal(apprId);
	}
	
	public void deleteappraisal(int apprId) {
		appraisalDao.deleteappraisal(apprId);
	}
	
	//appraisal template
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addappraisaltemp(AppraisalTempModel001MB appraisaltemp001MB) {
		appraisalDao.addappraisaltemp(appraisaltemp001MB);
	}
	
	public List<AppraisalTempModel001MB> listappraisaltemp() {
		return appraisalDao.listappraisaltemp();
	}

	public AppraisalTempModel001MB getappraisaltemp(int apptmpId) {
		return appraisalDao.getappraisaltemp(apptmpId);
	}
	
	public void deleteappraisaltemp(int apptmpId) {
		appraisalDao.deleteappraisaltemp(apptmpId);
	}
	
	
	

}
