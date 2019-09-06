package com.karya.service;

import java.util.List;

import com.karya.model.Budget001MB;
import com.karya.model.BudgetAccountType001MB;
import com.karya.model.BudgetMonthlyDistribution001MB;
import com.karya.model.BudgetVarianceReport001MB;
import com.karya.model.CostCenter001MB;

public interface IBudgetCostCenterService {
	
	public void addcostcenter(CostCenter001MB costcenter001MB);

	public List<CostCenter001MB> listcostcenter();
	
	public CostCenter001MB getcostcenter(int centId);
	
	public void deletecostcenter(int centId);
	
	//Budget account type
	
	public void addbudgetaccounttype(BudgetAccountType001MB budgetaccounttype001MB);

	public List<BudgetAccountType001MB> listbudgetaccounttype();
	
	public BudgetAccountType001MB getbudgetaccounttype(int bgaccId);
	
	public void deletebudgetaccounttype(int bgaccId);
	
	//budget
	
	public void addbudget(Budget001MB budget001MB);

	public List<Budget001MB> listbudget();
	
	public Budget001MB getbudget(int bgId);
	
	public void deletebudget(int bgId);
	
	//Budget monthly distribution
	
	public void addbudgetmonthlydistribution(BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB);

	public List<BudgetMonthlyDistribution001MB> listbudgetmonthlydistribution();
	
	public BudgetMonthlyDistribution001MB getbudgetmonthlydistribution(int bmdId);
	
	public void deletebudgetmonthlydistribution(int bmdId);
	
	//budget variance report
	
	public void addbudgetvariancereport(BudgetVarianceReport001MB budgetvariancereport001MB);

	public List<BudgetVarianceReport001MB> listbudgetvariancereport();
	
	public BudgetVarianceReport001MB getbudgetvariancereport(int varId);
	
	public void deletebudgetvariancereport(int varId);
	
	
	
	

}
