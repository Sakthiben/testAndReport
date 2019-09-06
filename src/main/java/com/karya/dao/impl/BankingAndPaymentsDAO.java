package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBankingAndPaymentsDAO;
import com.karya.model.BankClearance001MB;
import com.karya.model.BankReconcile001MB;
import com.karya.model.MatchPayment001MB;
import com.karya.model.UpdateBank001MB;

@Repository
@Transactional
public class BankingAndPaymentsDAO implements IBankingAndPaymentsDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Update Bank Trasaction
	
	public void addupdatebank(UpdateBank001MB updatebankmb) {
		entityManager.merge(updatebankmb);
	}
	
	@SuppressWarnings("unchecked")
	public List<UpdateBank001MB> listupdatebank() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UpdateBank001MB> cq = builder.createQuery(UpdateBank001MB.class);
		Root<UpdateBank001MB> root = cq.from(UpdateBank001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public UpdateBank001MB getUpdatebank(int id) {
		UpdateBank001MB updatebankmb = entityManager.find(UpdateBank001MB.class, id);
		return updatebankmb;
	}

	public void deleteupdatebank(int id) {
		UpdateBank001MB updatebankmb = entityManager.find(UpdateBank001MB.class, id);
		entityManager.remove(updatebankmb);
	}
	
	// Match Payments

	public void addmatchpayment(MatchPayment001MB matchpayment001mb) {
		entityManager.merge(matchpayment001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<MatchPayment001MB> listmatchpayments() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MatchPayment001MB> cq = builder.createQuery(MatchPayment001MB.class);
		Root<MatchPayment001MB> root = cq.from(MatchPayment001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public MatchPayment001MB getMatchpayment(int id) {
		MatchPayment001MB matchpayment001mb = entityManager.find(MatchPayment001MB.class, id);
		return matchpayment001mb;
	}

	public void deletematchpayment(int id) {
		MatchPayment001MB matchpayment001mb = entityManager.find(MatchPayment001MB.class, id);
		entityManager.remove(matchpayment001mb);
	}
	
	//bank clearance
	
	public void addbankclearance(BankClearance001MB bankclearance001mb) {
		entityManager.merge(bankclearance001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<BankClearance001MB> listbankclearance() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BankClearance001MB> cq = builder.createQuery(BankClearance001MB.class);
		Root<BankClearance001MB> root = cq.from(BankClearance001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public BankClearance001MB getbankclearance(int bankclrId) {
		BankClearance001MB bankclearance001mb = entityManager.find(BankClearance001MB.class, bankclrId);
		return bankclearance001mb;
	}

	public void deletebankclearance(int bankclrId) {
		BankClearance001MB bankclearance001mb = entityManager.find(BankClearance001MB.class, bankclrId);
		entityManager.remove(bankclearance001mb);
	}
	
	//bank reconcile
	
	public void addbankreconcile(BankReconcile001MB bankreconcile001mb) {
		entityManager.merge(bankreconcile001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<BankReconcile001MB> listbankreconcile() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BankReconcile001MB> cq = builder.createQuery(BankReconcile001MB.class);
		Root<BankReconcile001MB> root = cq.from(BankReconcile001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public BankReconcile001MB getbankreconcile(int bankrecId) {
		BankReconcile001MB bankreconcile001mb = entityManager.find(BankReconcile001MB.class, bankrecId);
		return bankreconcile001mb;
	}

	public void deletebankreconcile(int bankrecId) {
		BankReconcile001MB bankreconcile001mb = entityManager.find(BankReconcile001MB.class, bankrecId);
		entityManager.remove(bankreconcile001mb);
	}
}
