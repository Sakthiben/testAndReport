package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAccountsPayableDAO;
import com.karya.model.AccountsPayable001MB;

@Repository
@Transactional
public class AccountsPayableDAO implements IAccountsPayableDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addaccountspayable(AccountsPayable001MB accountspayablemb) {
		entityManager.merge(accountspayablemb);
	}
	
	@SuppressWarnings("unchecked")
	public List<AccountsPayable001MB> accountspayablelist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountsPayable001MB> cq = builder.createQuery(AccountsPayable001MB.class);
		Root<AccountsPayable001MB> root = cq.from(AccountsPayable001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public AccountsPayable001MB getAccountsPayable(int id) {
		AccountsPayable001MB accountspayablemb = entityManager.find(AccountsPayable001MB.class, id);
		return accountspayablemb;
	}

	public void deleteaccountspayable(int id) {
		AccountsPayable001MB accountspayablemb = entityManager.find(AccountsPayable001MB.class, id);
		entityManager.remove(accountspayablemb);
	}
}
