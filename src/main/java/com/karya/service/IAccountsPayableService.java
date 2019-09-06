package com.karya.service;

import java.util.List;

import com.karya.model.AccountsPayable001MB;

public interface IAccountsPayableService {

public List<AccountsPayable001MB> accountspayablelist();
	
	public void addaccountspayable(AccountsPayable001MB accountspayablemb);
	
	public AccountsPayable001MB getAccountsPayable(int id);
	
	public void deleteaccountspayable(int id);
}
