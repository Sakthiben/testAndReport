package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAccountsPayableDAO;
import com.karya.model.AccountsPayable001MB;
import com.karya.service.IAccountsPayableService;

@Service("accountspayableservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountsPayableService  implements IAccountsPayableService{

	@Autowired
	private IAccountsPayableDAO accountspayabledao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addaccountspayable(AccountsPayable001MB accountspayablemb) {
		accountspayabledao.addaccountspayable(accountspayablemb);
	}
	
	public List<AccountsPayable001MB> accountspayablelist() {
		return accountspayabledao.accountspayablelist();
	}
	
	public AccountsPayable001MB getAccountsPayable(int id) {
		return accountspayabledao.getAccountsPayable(id);
	}
	
	public void deleteaccountspayable(int id) {
		accountspayabledao.deleteaccountspayable(id);
	}

}
