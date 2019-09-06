package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITrialBalanceDAO;
import com.karya.model.AccountBalanceSheet001MB;
import com.karya.model.AccountCashFlow001MB;
import com.karya.model.AccountProfitLossStatement001MB;
import com.karya.model.TrialBalance001MB;

@Repository
@Transactional
public class TrialBalanceDAO implements ITrialBalanceDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addtrialbalance(TrialBalance001MB trialbalancemb) {
		entityManager.merge(trialbalancemb);
	}
	
	@SuppressWarnings("unchecked")
	public List<TrialBalance001MB> trialbalancelist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TrialBalance001MB> cq = builder.createQuery(TrialBalance001MB.class);
		Root<TrialBalance001MB> root = cq.from(TrialBalance001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public TrialBalance001MB gettrialbalance(int id) {
		TrialBalance001MB trialbalancemb = entityManager.find(TrialBalance001MB.class, id);
		return trialbalancemb;
	}

	public void deletetrialbalance(int id) {
		TrialBalance001MB trialbalancemb = entityManager.find(TrialBalance001MB.class, id);
		entityManager.remove(trialbalancemb);
	}
	
	// baalnce sheet
	
	
	@SuppressWarnings("unchecked")
	public List<AccountBalanceSheet001MB> listbalancesheet() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountBalanceSheet001MB> cq = builder.createQuery(AccountBalanceSheet001MB.class);
		Root<AccountBalanceSheet001MB> root = cq.from(AccountBalanceSheet001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addbalancesheet(AccountBalanceSheet001MB accountbalancesheet001mb) {
		entityManager.merge(accountbalancesheet001mb);
	}
	
	
	public AccountBalanceSheet001MB getbalancesheet(int absId) {
		AccountBalanceSheet001MB accountbalancesheet001mb = entityManager.find(AccountBalanceSheet001MB.class, absId);
		return accountbalancesheet001mb;
	}

	public void deletebalancesheet(int absId) {
		AccountBalanceSheet001MB accountbalancesheet001mb = entityManager.find(AccountBalanceSheet001MB.class, absId);
		entityManager.remove(accountbalancesheet001mb);
	}
	
	//cash flow
	
	@SuppressWarnings("unchecked")
	public List<AccountCashFlow001MB> listcashflow() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountCashFlow001MB> cq = builder.createQuery(AccountCashFlow001MB.class);
		Root<AccountCashFlow001MB> root = cq.from(AccountCashFlow001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addcashflow(AccountCashFlow001MB accountcashflow001mb) {
		entityManager.merge(accountcashflow001mb);
	}
	
	
	public AccountCashFlow001MB getcashflow(int acfId) {
		AccountCashFlow001MB accountcashflow001mb = entityManager.find(AccountCashFlow001MB.class, acfId);
		return accountcashflow001mb;
	}

	public void deletecashflow(int acfId) {
		AccountCashFlow001MB accountcashflow001mb = entityManager.find(AccountCashFlow001MB.class, acfId);
		entityManager.remove(accountcashflow001mb);
	}
	
	//profit loss statement
	
	@SuppressWarnings("unchecked")
	public List<AccountProfitLossStatement001MB> listprofitloss() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountProfitLossStatement001MB> cq = builder.createQuery(AccountProfitLossStatement001MB.class);
		Root<AccountProfitLossStatement001MB> root = cq.from(AccountProfitLossStatement001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public void addprofitloss(AccountProfitLossStatement001MB accountprofitlossstatement001mb) {
		entityManager.merge(accountprofitlossstatement001mb);
	}
	
	
	public AccountProfitLossStatement001MB getprofitloss(int aplsId) {
		AccountProfitLossStatement001MB accountprofitlossstatement001mb = entityManager.find(AccountProfitLossStatement001MB.class, aplsId);
		return accountprofitlossstatement001mb;
	}

	public void deleteprofitloss(int aplsId) {
		AccountProfitLossStatement001MB accountprofitlossstatement001mb = entityManager.find(AccountProfitLossStatement001MB.class, aplsId);
		entityManager.remove(accountprofitlossstatement001mb);
	}
	
	
	
	
	
}
