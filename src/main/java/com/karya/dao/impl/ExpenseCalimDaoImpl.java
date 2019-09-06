package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IExpenseclmDao;
import com.karya.model.ExpenseClaimModel001MB;

@Repository
@Transactional
public class ExpenseCalimDaoImpl implements IExpenseclmDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addExpenseclaim(ExpenseClaimModel001MB expenseclaim001MB) {
		entityManager.merge(expenseclaim001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ExpenseClaimModel001MB> listExpenseclaim() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ExpenseClaimModel001MB> cq = builder.createQuery(ExpenseClaimModel001MB.class);
		Root<ExpenseClaimModel001MB> root = cq.from(ExpenseClaimModel001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ExpenseClaimModel001MB getExpenseclaim(int expclmId) {
		ExpenseClaimModel001MB expenseclaim001MB = entityManager.find(ExpenseClaimModel001MB.class, expclmId);
		return expenseclaim001MB;
	}

	public void deleteExpenseclaim(int expclmId) {
		ExpenseClaimModel001MB expenseclaim001MB = entityManager.find(ExpenseClaimModel001MB.class, expclmId);
		entityManager.remove(expenseclaim001MB);
	}
	
	

}
