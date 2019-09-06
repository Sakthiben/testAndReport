package com.karya.service;

import java.util.List;

import com.karya.model.AccountsReceivable001MB;

public interface IAccountsReceivableService {

public List<AccountsReceivable001MB> accountsreceivable();
	
	public void addaccountsreceivable(AccountsReceivable001MB dailytimesheet);
	
	public AccountsReceivable001MB getAccountsReceivable(int id);

	public void deleteaccountsreceivable(int id);
	
}
