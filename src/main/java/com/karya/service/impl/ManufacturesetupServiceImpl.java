package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IManufactureSetupDao;
import com.karya.model.ManufactureSetup001MB;
import com.karya.service.IManufacuturesetupService;

@Service("manufacturesetupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManufacturesetupServiceImpl implements IManufacuturesetupService{
	
	@Autowired
	private IManufactureSetupDao manufactureDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addmanufacturesetup(ManufactureSetup001MB manufacturesetup001MB) {
		manufactureDao.addmanufacturesetup(manufacturesetup001MB);
	}
	
	public List<ManufactureSetup001MB> listmanufacturesetup() {
		return manufactureDao.listmanufacturesetup();
	}

	public ManufactureSetup001MB getmanufacturesetup(int mansetId) {
		return manufactureDao.getmanufacturesetup(mansetId);
	}
	
	public void deletemanufacturesetup(int mansetId) {
		manufactureDao.deletemanufacturesetup(mansetId);
	}

}
