package com.karya.dao;

import java.util.List;

import com.karya.model.AccountBalanceSheet001MB;
import com.karya.model.AccountCashFlow001MB;
import com.karya.model.AccountProfitLossStatement001MB;
import com.karya.model.TrialBalance001MB;

public interface ITrialBalanceDAO {

	public List<TrialBalance001MB> trialbalancelist();
	
	public void addtrialbalance(TrialBalance001MB trialbalancemb);
	
	public TrialBalance001MB gettrialbalance(int id);
	
	public void deletetrialbalance(int id);
	
	//balance sheet
	
	public List<AccountBalanceSheet001MB> listbalancesheet();
	
	public void addbalancesheet(AccountBalanceSheet001MB accountbalancesheet001mb);
	
	public AccountBalanceSheet001MB getbalancesheet(int absId);
	
	public void deletebalancesheet(int absId);
	
	//Cash Flow
	
	public List<AccountCashFlow001MB> listcashflow();
	
	public void addcashflow(AccountCashFlow001MB accountcashflow001mb);
	
	public AccountCashFlow001MB getcashflow(int acfId);
	
	public void deletecashflow(int acfId);
	
	// Profit loss statement
	
	public List<AccountProfitLossStatement001MB> listprofitloss();
	
	public void addprofitloss(AccountProfitLossStatement001MB accountprofitlossstatement001mb);
	
	public AccountProfitLossStatement001MB getprofitloss(int aplsId);
	
	public void deleteprofitloss(int aplsId);
	
	
}
