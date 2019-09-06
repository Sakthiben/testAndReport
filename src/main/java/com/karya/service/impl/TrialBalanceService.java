package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITrialBalanceDAO;
import com.karya.model.AccountBalanceSheet001MB;
import com.karya.model.AccountCashFlow001MB;
import com.karya.model.AccountProfitLossStatement001MB;
import com.karya.model.TrialBalance001MB;
import com.karya.service.ITrialBalanceService;

@Service("trialbalanceservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrialBalanceService implements ITrialBalanceService {

	@Autowired
	private ITrialBalanceDAO trialbalancedao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addtrialbalance(TrialBalance001MB trialbalancemb) {
		trialbalancedao.addtrialbalance(trialbalancemb);
	}
	
	public List<TrialBalance001MB> trialbalancelist() {
		return trialbalancedao.trialbalancelist();
	}
	
	public TrialBalance001MB gettrialbalance(int id) {
		return trialbalancedao.gettrialbalance(id);
	}
	
	public void deletetrialbalance(int id) {
		trialbalancedao.deletetrialbalance(id);
	}
	
	//balance sheet
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addbalancesheet(AccountBalanceSheet001MB accountbalancesheet001mb) {
		trialbalancedao.addbalancesheet(accountbalancesheet001mb);
	}
	
	public List<AccountBalanceSheet001MB> listbalancesheet() {
		return trialbalancedao.listbalancesheet();
	}
	
	public AccountBalanceSheet001MB getbalancesheet(int absId) {
		return trialbalancedao.getbalancesheet(absId);
	}
	
	public void deletebalancesheet(int absId) {
		trialbalancedao.deletebalancesheet(absId);
	}
	
	//cash flow
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addcashflow(AccountCashFlow001MB accountcashflow001mb) {
		trialbalancedao.addcashflow(accountcashflow001mb);
	}
	
	public List<AccountCashFlow001MB> listcashflow() {
		return trialbalancedao.listcashflow();
	}
	
	public AccountCashFlow001MB getcashflow(int acfId) {
		return trialbalancedao.getcashflow(acfId);
	}
	
	public void deletecashflow(int acfId) {
		trialbalancedao.deletecashflow(acfId);
	}
	
	//profit loss
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addprofitloss(AccountProfitLossStatement001MB accountprofitlossstatement001mb) {
		trialbalancedao.addprofitloss(accountprofitlossstatement001mb);
	}
	
	public List<AccountProfitLossStatement001MB> listprofitloss() {
		return trialbalancedao.listprofitloss();
	}
	
	public AccountProfitLossStatement001MB getprofitloss(int aplsId) {
		return trialbalancedao.getprofitloss(aplsId);
	}
	
	public void deleteprofitloss(int aplsId) {
		trialbalancedao.deleteprofitloss(aplsId);
	}
	

}
