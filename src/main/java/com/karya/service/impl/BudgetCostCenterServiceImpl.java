package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBudgetCostCenterDao;
import com.karya.model.Budget001MB;
import com.karya.model.BudgetAccountType001MB;
import com.karya.model.BudgetMonthlyDistribution001MB;
import com.karya.model.BudgetVarianceReport001MB;
import com.karya.model.CostCenter001MB;
import com.karya.service.IBudgetCostCenterService;

@Service("budgetcostcenterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BudgetCostCenterServiceImpl implements IBudgetCostCenterService{
	
	@Autowired
	private IBudgetCostCenterDao budgetcostcenterDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcostcenter(CostCenter001MB costcenter001MB) {
		budgetcostcenterDao.addcostcenter(costcenter001MB);
	}
	
	public List<CostCenter001MB> listcostcenter() {
		return budgetcostcenterDao.listcostcenter();
	}

	public CostCenter001MB getcostcenter(int centId) {
		return budgetcostcenterDao.getcostcenter(centId);
	}
	
	public void deletecostcenter(int centId) {
		budgetcostcenterDao.deletecostcenter(centId);
	}
	
	// Budget account type
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbudgetaccounttype(BudgetAccountType001MB budgetaccounttype001MB) {
		budgetcostcenterDao.addbudgetaccounttype(budgetaccounttype001MB);
	}
	
	public List<BudgetAccountType001MB> listbudgetaccounttype() {
		return budgetcostcenterDao.listbudgetaccounttype();
	}

	public BudgetAccountType001MB getbudgetaccounttype(int bgaccId) {
		return budgetcostcenterDao.getbudgetaccounttype(bgaccId);
	}
	
	public void deletebudgetaccounttype(int bgaccId) {
		budgetcostcenterDao.deletebudgetaccounttype(bgaccId);
	}
	
	//budget
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbudget(Budget001MB budget001MB) {
		budgetcostcenterDao.addbudget(budget001MB);
	}
	
	public List<Budget001MB> listbudget() {
		return budgetcostcenterDao.listbudget();
	}

	public Budget001MB getbudget(int bgId) {
		return budgetcostcenterDao.getbudget(bgId);
	}
	
	public void deletebudget(int bgId) {
		budgetcostcenterDao.deletebudget(bgId);
	}
	
	//budget monthly distribution
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbudgetmonthlydistribution(BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB) {
		budgetcostcenterDao.addbudgetmonthlydistribution(budgetmonthlydistribution001MB);
	}
	
	public List<BudgetMonthlyDistribution001MB> listbudgetmonthlydistribution() {
		return budgetcostcenterDao.listbudgetmonthlydistribution();
	}

	public BudgetMonthlyDistribution001MB getbudgetmonthlydistribution(int bmdId) {
		return budgetcostcenterDao.getbudgetmonthlydistribution(bmdId);
	}
	
	public void deletebudgetmonthlydistribution(int bmdId) {
		budgetcostcenterDao.deletebudgetmonthlydistribution(bmdId);
	}
	
	//budget variance report
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbudgetvariancereport(BudgetVarianceReport001MB budgetvariancereport001MB) {
		budgetcostcenterDao.addbudgetvariancereport(budgetvariancereport001MB);
	}
	
	public List<BudgetVarianceReport001MB> listbudgetvariancereport() {
		return budgetcostcenterDao.listbudgetvariancereport();
	}

	public BudgetVarianceReport001MB getbudgetvariancereport(int varId) {
		return budgetcostcenterDao.getbudgetvariancereport(varId);
	}
	
	public void deletebudgetvariancereport(int varId) {
		budgetcostcenterDao.deletebudgetvariancereport(varId);
	}
	
	
	
	
	
	
	
	
	
	

}
