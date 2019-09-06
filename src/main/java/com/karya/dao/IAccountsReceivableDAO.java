package com.karya.dao;

import java.util.List;

import com.karya.model.AccountsReceivable001MB;

public interface IAccountsReceivableDAO {
	
public List<AccountsReceivable001MB> accountsreceivable();
	
	public void addaccountsreceivable(AccountsReceivable001MB accountsreceivable);
	
	public AccountsReceivable001MB getAccountsReceivable(int id);
	
	public void deleteaccountsreceivable(int id);
}
