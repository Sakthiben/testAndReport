package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IPurchaseDao;
import com.karya.model.PRMatReq001MB;
import com.karya.model.PRPurOrd001MB;
import com.karya.model.PRQuotReq001MB;
import com.karya.model.PRSuQuotReq001MB;

@Repository
@Transactional
public class PurchaseDaoImpl implements IPurchaseDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addprmatreq(PRMatReq001MB prmatreq1MB) {
		entityManager.merge(prmatreq1MB);
	}

	@SuppressWarnings("unchecked")
	public List<PRMatReq001MB> listprmatreq() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PRMatReq001MB> cq = builder.createQuery(PRMatReq001MB.class);
		Root<PRMatReq001MB> root = cq.from(PRMatReq001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PRMatReq001MB getprmatreq(int pmrId) {
		PRMatReq001MB prmatreq1MB = entityManager.find(PRMatReq001MB.class, pmrId);
		return prmatreq1MB;
	}

	public void deleteprmatreq(int pmrId) {
		PRMatReq001MB prmatreq1MB = entityManager.find(PRMatReq001MB.class, pmrId);
		entityManager.remove(prmatreq1MB);
	}
	
	//Quot req
	
	public void addprquotreq(PRQuotReq001MB prquotreq1MB) {
		entityManager.merge(prquotreq1MB);
	}

	@SuppressWarnings("unchecked")
	public List<PRQuotReq001MB> listprquotreq() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PRQuotReq001MB> cq = builder.createQuery(PRQuotReq001MB.class);
		Root<PRQuotReq001MB> root = cq.from(PRQuotReq001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PRQuotReq001MB getprquotreq(int prqId) {
		PRQuotReq001MB prquotreq1MB = entityManager.find(PRQuotReq001MB.class, prqId);
		return prquotreq1MB;
	}

	public void deleteprquotreq(int prqId) {
		PRQuotReq001MB prquotreq1MB = entityManager.find(PRQuotReq001MB.class, prqId);
		entityManager.remove(prquotreq1MB);
	}
	
	//Supplier quot
	
	public void addprsuquotreq(PRSuQuotReq001MB prsuquotreq1MB) {
		entityManager.merge(prsuquotreq1MB);
	}

	@SuppressWarnings("unchecked")
	public List<PRSuQuotReq001MB> listprsuquotreq() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PRSuQuotReq001MB> cq = builder.createQuery(PRSuQuotReq001MB.class);
		Root<PRSuQuotReq001MB> root = cq.from(PRSuQuotReq001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PRSuQuotReq001MB getprsuquotreq(int prsrId) {
		PRSuQuotReq001MB prsuquotreq1MB = entityManager.find(PRSuQuotReq001MB.class, prsrId);
		return prsuquotreq1MB;
	}

	public void deleteprsuquotreq(int prsrId) {
		PRSuQuotReq001MB prsuquotreq1MB = entityManager.find(PRSuQuotReq001MB.class, prsrId);
		entityManager.remove(prsuquotreq1MB);
	}
	
	//Purchase quot
	
	public void addprpurorder(PRPurOrd001MB prpurorder1MB) {
		entityManager.merge(prpurorder1MB);
	}

	@SuppressWarnings("unchecked")
	public List<PRPurOrd001MB> listprpurorder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PRPurOrd001MB> cq = builder.createQuery(PRPurOrd001MB.class);
		Root<PRPurOrd001MB> root = cq.from(PRPurOrd001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PRPurOrd001MB getprpurorder(int proId) {
		PRPurOrd001MB prpurorder1MB = entityManager.find(PRPurOrd001MB.class, proId);
		return prpurorder1MB;
	}

	public void deleteprpurorder(int proId) {
		PRPurOrd001MB prpurorder1MB = entityManager.find(PRPurOrd001MB.class, proId);
		entityManager.remove(prpurorder1MB);
	}
	
	
	
	
	
	

}
