package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAccountsReceivableDAO;
import com.karya.model.AccountsReceivable001MB;
import com.karya.service.IAccountsReceivableService;

@Service("accountsreceivableservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountsReceivableService implements IAccountsReceivableService {
	
	@Autowired
	private IAccountsReceivableDAO accountsreceivabledao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addaccountsreceivable(AccountsReceivable001MB accountsreceivablemb) {
		accountsreceivabledao.addaccountsreceivable(accountsreceivablemb);
	}
	
	public List<AccountsReceivable001MB> accountsreceivable() {
		return accountsreceivabledao.accountsreceivable();
	}
	
	public AccountsReceivable001MB getAccountsReceivable(int id) {
		return accountsreceivabledao.getAccountsReceivable(id);
	}
	
	public void deleteaccountsreceivable(int id) {
		accountsreceivabledao.deleteaccountsreceivable(id);
	}

}
