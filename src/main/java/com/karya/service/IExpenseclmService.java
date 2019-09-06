package com.karya.service;

import java.util.List;

import com.karya.model.ExpenseClaimModel001MB;

public interface IExpenseclmService {
	
	public void addExpenseclaim(ExpenseClaimModel001MB expenseclaim001MB);

	public List<ExpenseClaimModel001MB> listExpenseclaim();
	
	public ExpenseClaimModel001MB getExpenseclaim(int expclmId);
	
	public void deleteExpenseclaim(int expclmId);

}
