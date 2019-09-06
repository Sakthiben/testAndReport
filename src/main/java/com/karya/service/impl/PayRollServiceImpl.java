package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IPayRollDao;
import com.karya.model.Payroll001MB;
import com.karya.model.ProcessPR001MB;
import com.karya.model.SalaryCompo001MB;
import com.karya.model.SalaryStruct001MB;
import com.karya.service.IPayRollService;

@Service("payrollService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PayRollServiceImpl implements IPayRollService{
	
	@Autowired
	private IPayRollDao payrollDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpayroll(Payroll001MB payroll001MB) {
		payrollDao.addpayroll(payroll001MB);
	}
	
	public List<Payroll001MB> listpayroll() {
		return payrollDao.listpayroll();
	}

	public Payroll001MB getpayroll(int prId) {
		return payrollDao.getpayroll(prId);
	}
	
	public void deletepayroll(int prId) {
		payrollDao.deletepayroll(prId);
	}
	
	//Process Pay Roll
	public List<ProcessPR001MB> listprocesspr(){
		return payrollDao.listprocesspr();
		
	}
	
	public ProcessPR001MB getprocesspr(int processId){
	return payrollDao.getprocesspr(processId);
	}
	
	public void deleteprocesspr(int processId){
		payrollDao.deleteprocesspr(processId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprocesspr(ProcessPR001MB processpr001MB){
		payrollDao.addprocesspr(processpr001MB);
	}
	

	//salary structure
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsalstruct(SalaryStruct001MB salarystruct001MB) {
		payrollDao.addsalstruct(salarystruct001MB);
	}
	
	public List<SalaryStruct001MB> listsalstruct() {
		return payrollDao.listsalstruct();
	}

	public SalaryStruct001MB getsalstruct(int strId) {
		return payrollDao.getsalstruct(strId);
	}
	
	public void deletesalstruct(int strId) {
		payrollDao.deletesalstruct(strId);
	}
	
	//salary component
	public List<SalaryCompo001MB> listsalcomp(){
		return payrollDao.listsalcomp();
		
	}
	
	public SalaryCompo001MB getsalcomp(int salcompId){
	return payrollDao.getsalcomp(salcompId);
	}
	
	public void deletesalcomp(int salcompId){
		payrollDao.deletesalcomp(salcompId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addsalcomp(SalaryCompo001MB salarycompo001MB){
		payrollDao.addsalcomp(salarycompo001MB);
	}
	

}
