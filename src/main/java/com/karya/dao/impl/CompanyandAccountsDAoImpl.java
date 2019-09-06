package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICompanyandAccountsDao;
import com.karya.model.AccGenLedge001MB;
import com.karya.model.AccountChart001MB;
import com.karya.model.CompanyAccounts001MB;
import com.karya.model.JournalEntry001MB;

@Repository
@Transactional
public class CompanyandAccountsDAoImpl implements ICompanyandAccountsDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addaccgenledge(AccGenLedge001MB accgenledge001mb) {
		entityManager.merge(accgenledge001mb);
	}

	@SuppressWarnings("unchecked")
	public List<AccGenLedge001MB> listaccgenledge() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccGenLedge001MB> cq = builder.createQuery(AccGenLedge001MB.class);
		Root<AccGenLedge001MB> root = cq.from(AccGenLedge001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public AccGenLedge001MB getaccgenledge(int accglId) {
		AccGenLedge001MB accgenledge001mb = entityManager.find(AccGenLedge001MB.class, accglId);
		return accgenledge001mb;
	}

	public void deleteaccgenledge(int accglId) {
		AccGenLedge001MB accgenledge001mb = entityManager.find(AccGenLedge001MB.class, accglId);
		entityManager.remove(accgenledge001mb);
	}
	
	//Journal Entry
	
	public void addjournalentry(JournalEntry001MB journalentry001mb) {
		entityManager.merge(journalentry001mb);
	}

	@SuppressWarnings("unchecked")
	public List<JournalEntry001MB> listjournalentry() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<JournalEntry001MB> cq = builder.createQuery(JournalEntry001MB.class);
		Root<JournalEntry001MB> root = cq.from(JournalEntry001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public JournalEntry001MB getjournalentry(int jeId) {
		JournalEntry001MB journalentry001mb = entityManager.find(JournalEntry001MB.class, jeId);
		return journalentry001mb;
	}

	public void deletejournalentry(int jeId) {
		JournalEntry001MB journalentry001mb = entityManager.find(JournalEntry001MB.class, jeId);
		entityManager.remove(journalentry001mb);
	}
	
	//Account charts
	
	public void addaccountchart(AccountChart001MB accountchart001mb) {
		entityManager.merge(accountchart001mb);
	}

	@SuppressWarnings("unchecked")
	public List<AccountChart001MB> listaccountchart() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountChart001MB> cq = builder.createQuery(AccountChart001MB.class);
		Root<AccountChart001MB> root = cq.from(AccountChart001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public AccountChart001MB getaccountchart(int chartId) {
		AccountChart001MB accountchart001mb = entityManager.find(AccountChart001MB.class, chartId);
		return accountchart001mb;
	}

	public void deleteaccountchart(int chartId) {
		AccountChart001MB accountchart001mb = entityManager.find(AccountChart001MB.class, chartId);
		entityManager.remove(accountchart001mb);
	}
	
	//Company Accounts
	
	public void addcompanyaccounts(CompanyAccounts001MB companyaccounts001mb) {
		entityManager.merge(companyaccounts001mb);
	}

	@SuppressWarnings("unchecked")
	public List<CompanyAccounts001MB> listcompanyaccounts() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CompanyAccounts001MB> cq = builder.createQuery(CompanyAccounts001MB.class);
		Root<CompanyAccounts001MB> root = cq.from(CompanyAccounts001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CompanyAccounts001MB getcompanyaccounts(int caId) {
		CompanyAccounts001MB companyaccounts001mb = entityManager.find(CompanyAccounts001MB.class, caId);
		return companyaccounts001mb;
	}

	public void deletecompanyaccounts(int caId) {
		CompanyAccounts001MB companyaccounts001mb = entityManager.find(CompanyAccounts001MB.class, caId);
		entityManager.remove(companyaccounts001mb);
	}
	
	
	
	
	
	

}
