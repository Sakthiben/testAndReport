package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBudgetCostCenterDao;
import com.karya.model.Budget001MB;
import com.karya.model.BudgetAccountType001MB;
import com.karya.model.BudgetMonthlyDistribution001MB;
import com.karya.model.BudgetVarianceReport001MB;
import com.karya.model.CostCenter001MB;

@Repository
@Transactional
public class BudgetCostCenterDaoImpl implements IBudgetCostCenterDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addcostcenter(CostCenter001MB costcenter001MB) {
		entityManager.merge(costcenter001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CostCenter001MB> listcostcenter() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CostCenter001MB> cq = builder.createQuery(CostCenter001MB.class);
		Root<CostCenter001MB> root = cq.from(CostCenter001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CostCenter001MB getcostcenter(int centId) {
		CostCenter001MB costcenter001MB = entityManager.find(CostCenter001MB.class, centId);
		return costcenter001MB;
	}

	public void deletecostcenter(int centId) {
		CostCenter001MB costcenter001MB = entityManager.find(CostCenter001MB.class, centId);
		entityManager.remove(costcenter001MB);
	}
	
	//budget account type
	
	
	public void addbudgetaccounttype(BudgetAccountType001MB budgetaccounttype001MB) {
		entityManager.merge(budgetaccounttype001MB);
	}

	@SuppressWarnings("unchecked")
	public List<BudgetAccountType001MB> listbudgetaccounttype() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BudgetAccountType001MB> cq = builder.createQuery(BudgetAccountType001MB.class);
		Root<BudgetAccountType001MB> root = cq.from(BudgetAccountType001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public BudgetAccountType001MB getbudgetaccounttype(int bgaccId) {
		BudgetAccountType001MB budgetaccounttype001MB = entityManager.find(BudgetAccountType001MB.class, bgaccId);
		return budgetaccounttype001MB;
	}

	public void deletebudgetaccounttype(int bgaccId) {
		BudgetAccountType001MB budgetaccounttype001MB = entityManager.find(BudgetAccountType001MB.class, bgaccId);
		entityManager.remove(budgetaccounttype001MB);
	}
	
	//budget
	
	public void addbudget(Budget001MB budget001MB) {
		entityManager.merge(budget001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Budget001MB> listbudget() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Budget001MB> cq = builder.createQuery(Budget001MB.class);
		Root<Budget001MB> root = cq.from(Budget001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Budget001MB getbudget(int bgId) {
		Budget001MB budget001MB = entityManager.find(Budget001MB.class, bgId);
		return budget001MB;
	}

	public void deletebudget(int bgId) {
		Budget001MB budget001MB = entityManager.find(Budget001MB.class, bgId);
		entityManager.remove(budget001MB);
	}
	
	//budget monthly distribution
	
	public void addbudgetmonthlydistribution(BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB) {
		entityManager.merge(budgetmonthlydistribution001MB);
	}

	@SuppressWarnings("unchecked")
	public List<BudgetMonthlyDistribution001MB> listbudgetmonthlydistribution() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BudgetMonthlyDistribution001MB> cq = builder.createQuery(BudgetMonthlyDistribution001MB.class);
		Root<BudgetMonthlyDistribution001MB> root = cq.from(BudgetMonthlyDistribution001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public BudgetMonthlyDistribution001MB getbudgetmonthlydistribution(int bmdId) {
		BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB = entityManager.find(BudgetMonthlyDistribution001MB.class, bmdId);
		return budgetmonthlydistribution001MB;
	}

	public void deletebudgetmonthlydistribution(int bmdId) {
		BudgetMonthlyDistribution001MB budgetmonthlydistribution001MB = entityManager.find(BudgetMonthlyDistribution001MB.class, bmdId);
		entityManager.remove(budgetmonthlydistribution001MB);
	}
	
	//budget variance report
	
	public void addbudgetvariancereport(BudgetVarianceReport001MB budgetvariancereport001MB) {
		entityManager.merge(budgetvariancereport001MB);
	}

	@SuppressWarnings("unchecked")
	public List<BudgetVarianceReport001MB> listbudgetvariancereport() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BudgetVarianceReport001MB> cq = builder.createQuery(BudgetVarianceReport001MB.class);
		Root<BudgetVarianceReport001MB> root = cq.from(BudgetVarianceReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public BudgetVarianceReport001MB getbudgetvariancereport(int varId) {
		BudgetVarianceReport001MB budgetvariancereport001MB = entityManager.find(BudgetVarianceReport001MB.class, varId);
		return budgetvariancereport001MB;
	}

	public void deletebudgetvariancereport(int varId) {
		BudgetVarianceReport001MB budgetvariancereport001MB = entityManager.find(BudgetVarianceReport001MB.class, varId);
		entityManager.remove(budgetvariancereport001MB);
	}
	
	
	
	
	
	
	
	
	

}
