package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmploymentTypeDao;
import com.karya.model.Branch001MB;
import com.karya.model.Designation001MB;
import com.karya.model.EmploymentType001MB;
import com.karya.service.IEmploymentTypeService;

@Service("employmenttypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IEmploymentServiceImpl implements IEmploymentTypeService{
	
	@Autowired
	private IEmploymentTypeDao employmentTypeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmploymentType(EmploymentType001MB employmenttype001MB) {
		employmentTypeDao.addEmploymentType(employmenttype001MB);
	}
	
	public List<EmploymentType001MB> listEmploymenttype() {
		return employmentTypeDao.listEmploymenttype();
	}

	public EmploymentType001MB getEmploymenttype(int etypeId) {
		return employmentTypeDao.getEmploymenttype(etypeId);
	}
	
	public void deleteEmploymenttype(int etypeId) {
		employmentTypeDao.deleteEmploymenttype(etypeId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbranch(Branch001MB branch001MB) {
		employmentTypeDao.addbranch(branch001MB);
	}
	
	public List<Branch001MB> listbranch() {
		return employmentTypeDao.listbranch();
	}

	public Branch001MB getbranch(int branchId) {
		return employmentTypeDao.getbranch(branchId);
	}
	
	public void deletebranch(int branchId) {
		employmentTypeDao.deletebranch(branchId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void adddesignation(Designation001MB designation001MB) {
		employmentTypeDao.adddesignation(designation001MB);
	}
	
	public List<Designation001MB> listdesignation() {
		return employmentTypeDao.listdesignation();
	}

	public Designation001MB getdesignation(int designId) {
		return employmentTypeDao.getdesignation(designId);
	}
	
	public void deletedesignation(int designId) {
		employmentTypeDao.deletedesignation(designId);
	}
	
	
	

}
