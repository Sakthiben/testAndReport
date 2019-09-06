package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILeadDAO;
import com.karya.model.Lead001MB;
import com.karya.service.ILeadService;

@Service("LeadService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeadServiceImpl implements ILeadService {
	
	@Autowired
	private ILeadDAO leaddao;
	

	@Override
	public List<Lead001MB> listleaddetails() {
		return  leaddao.listleaddetails();
				
	}

	@Override
	public void addleaddetails(Lead001MB lead) {
	
		leaddao.addleaddetails(lead);
	}

	@Override
	public Lead001MB getleaddetails(int id) {
	
		return leaddao.getleaddetails(id);
	}

	@Override
	public void deleteleaddetails(int id) {
	
		leaddao.deleteleaddetails(id);
		
	}
	
	
	
}
	