package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAccountsReceivableDAO;
import com.karya.model.AccountsReceivable001MB;

@Repository
@Transactional
public class AccountsReceivableDAO implements IAccountsReceivableDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addaccountsreceivable(AccountsReceivable001MB accountsreceivablemb) {
		entityManager.merge(accountsreceivablemb);
	}
	
	@SuppressWarnings("unchecked")
	public List<AccountsReceivable001MB> accountsreceivable() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountsReceivable001MB> cq = builder.createQuery(AccountsReceivable001MB.class);
		Root<AccountsReceivable001MB> root = cq.from(AccountsReceivable001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public AccountsReceivable001MB getAccountsReceivable(int id) {
		AccountsReceivable001MB accountsreceivablemb = entityManager.find(AccountsReceivable001MB.class, id);
		return accountsreceivablemb;
	}

	public void deleteaccountsreceivable(int id) {
		AccountsReceivable001MB accountsreceivablemb = entityManager.find(AccountsReceivable001MB.class, id);
		entityManager.remove(accountsreceivablemb);
	}

}
