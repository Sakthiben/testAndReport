package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IExpenseclmDao;
import com.karya.model.ExpenseClaimModel001MB;
import com.karya.service.IExpenseclmService;

@Service("expenseclmService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExpenseclmServiceImpl implements IExpenseclmService{
	
	@Autowired
	private IExpenseclmDao expenseDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addExpenseclaim(ExpenseClaimModel001MB expenseclaim001MB) {
		expenseDao.addExpenseclaim(expenseclaim001MB);
	}
	
	public List<ExpenseClaimModel001MB> listExpenseclaim() {
		return expenseDao.listExpenseclaim();
	}

	public ExpenseClaimModel001MB getExpenseclaim(int expclmId) {
		return expenseDao.getExpenseclaim(expclmId);
	}
	
	public void deleteExpenseclaim(int expclmId) {
		expenseDao.deleteExpenseclaim(expclmId);
	}
	

}
