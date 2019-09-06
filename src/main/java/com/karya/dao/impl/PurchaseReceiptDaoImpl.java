package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IPurchaseReceiptDAO;
import com.karya.model.Purchase001MB;

@Repository
@Transactional
public class PurchaseReceiptDaoImpl implements IPurchaseReceiptDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	
	public List<Purchase001MB> listpurchases() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Purchase001MB> cq = builder.createQuery(Purchase001MB.class);
		Root<Purchase001MB> root = cq.from(Purchase001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();				
	}

	
	public void addpurchase(Purchase001MB purchase) {
		entityManager.merge(purchase);
		
	}
	public Purchase001MB getpurchasedetails(int id) {
	
		Purchase001MB purchase = entityManager.find(Purchase001MB.class,id);
		return purchase;		
	}

	
	public void deletepurchasedetails(int id) {
		
		Purchase001MB purchase = entityManager.find(Purchase001MB.class,id);
		entityManager.remove(purchase);
		
	}
}	

