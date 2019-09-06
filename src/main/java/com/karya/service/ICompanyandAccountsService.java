package com.karya.service;

import java.util.List;

import com.karya.model.AccGenLedge001MB;
import com.karya.model.AccountChart001MB;
import com.karya.model.CompanyAccounts001MB;
import com.karya.model.JournalEntry001MB;

public interface ICompanyandAccountsService {
	
	public void addaccgenledge(AccGenLedge001MB accgenledge001mb);

	public List<AccGenLedge001MB> listaccgenledge();
	
	public AccGenLedge001MB getaccgenledge(int accglId);
	
	public void deleteaccgenledge(int accglId);
	
	//Journal Entry
	
		public void addjournalentry(JournalEntry001MB journalentry001mb);

		public List<JournalEntry001MB> listjournalentry();
		
		public JournalEntry001MB getjournalentry(int jeId);
		
		public void deletejournalentry(int jeId);
		
		//Account Charts
		
		public void addaccountchart(AccountChart001MB accountchart001mb);

		public List<AccountChart001MB> listaccountchart();
		
		public AccountChart001MB getaccountchart(int chartId);
		
		public void deleteaccountchart(int chartId);
		
		
		//Company Accounts
		
		public void addcompanyaccounts(CompanyAccounts001MB companyaccounts001mb);

		public List<CompanyAccounts001MB> listcompanyaccounts();
		
		public CompanyAccounts001MB getcompanyaccounts(int caId);
		
		public void deletecompanyaccounts(int caId);
		
		

}
