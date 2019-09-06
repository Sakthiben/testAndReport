package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICompanyandAccountsDao;
import com.karya.model.AccGenLedge001MB;
import com.karya.model.AccountChart001MB;
import com.karya.model.Appraisal001MB;
import com.karya.model.CompanyAccounts001MB;
import com.karya.model.JournalEntry001MB;
import com.karya.service.ICompanyandAccountsService;

@Service("companyandaccountsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompanyandAccountsServiceImpl implements ICompanyandAccountsService{
	
	@Autowired
	private ICompanyandAccountsDao companyandaccountsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addaccgenledge(AccGenLedge001MB accgenledge001mb) {
		companyandaccountsDao.addaccgenledge(accgenledge001mb);
	}
	
	public List<AccGenLedge001MB> listaccgenledge() {
		return companyandaccountsDao.listaccgenledge();
	}

	public AccGenLedge001MB getaccgenledge(int accglId) {
		return companyandaccountsDao.getaccgenledge(accglId);
	}
	
	public void deleteaccgenledge(int accglId) {
		companyandaccountsDao.deleteaccgenledge(accglId);
	}
	
	//Journal Entry
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addjournalentry(JournalEntry001MB journalentry001mb) {
		companyandaccountsDao.addjournalentry(journalentry001mb);
	}
	
	public List<JournalEntry001MB> listjournalentry() {
		return companyandaccountsDao.listjournalentry();
	}

	public JournalEntry001MB getjournalentry(int jeId) {
		return companyandaccountsDao.getjournalentry(jeId);
	}
	
	public void deletejournalentry(int jeId) {
		companyandaccountsDao.deletejournalentry(jeId);
	}
	
	//Account chart
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addaccountchart(AccountChart001MB accountchart001mb) {
		companyandaccountsDao.addaccountchart(accountchart001mb);
	}
	
	public List<AccountChart001MB> listaccountchart() {
		return companyandaccountsDao.listaccountchart();
	}

	public AccountChart001MB getaccountchart(int chartId) {
		return companyandaccountsDao.getaccountchart(chartId);
	}
	
	public void deleteaccountchart(int chartId) {
		companyandaccountsDao.deleteaccountchart(chartId);
	}
	
	//Company accounts
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcompanyaccounts(CompanyAccounts001MB companyaccounts001mb) {
		companyandaccountsDao.addcompanyaccounts(companyaccounts001mb);
	}
	
	public List<CompanyAccounts001MB> listcompanyaccounts() {
		return companyandaccountsDao.listcompanyaccounts();
	}

	public CompanyAccounts001MB getcompanyaccounts(int caId) {
		return companyandaccountsDao.getcompanyaccounts(caId);
	}
	
	public void deletecompanyaccounts(int caId) {
		companyandaccountsDao.deletecompanyaccounts(caId);
	}
	
	
	

}
