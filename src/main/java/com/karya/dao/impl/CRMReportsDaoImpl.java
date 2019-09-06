package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMReportsDao;
import com.karya.model.CrmMinTimeResp001MB;
import com.karya.model.InactiveCust001MB;
import com.karya.model.LeadDetail001MB;

@Repository
@Transactional
public class CRMReportsDaoImpl implements ICRMReportsDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addmintimeresp(CrmMinTimeResp001MB crmmintimeresp001MB) {
		entityManager.merge(crmmintimeresp001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CrmMinTimeResp001MB> listmintimeresp() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CrmMinTimeResp001MB> cq = builder.createQuery(CrmMinTimeResp001MB.class);
		Root<CrmMinTimeResp001MB> root = cq.from(CrmMinTimeResp001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CrmMinTimeResp001MB getmintimeresp(int mrpId) {
		CrmMinTimeResp001MB crmmintimeresp001MB = entityManager.find(CrmMinTimeResp001MB.class, mrpId);
		return crmmintimeresp001MB;
	}

	public void deletemintimeresp(int mrpId) {
		CrmMinTimeResp001MB crmmintimeresp001MB = entityManager.find(CrmMinTimeResp001MB.class, mrpId);
		entityManager.remove(crmmintimeresp001MB);
	}
	
	//Lead Details
	
	public void addleaddetail(LeadDetail001MB leadetail001MB) {
		entityManager.merge(leadetail001MB);
	}

	@SuppressWarnings("unchecked")
	public List<LeadDetail001MB> listleaddetail() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LeadDetail001MB> cq = builder.createQuery(LeadDetail001MB.class);
		Root<LeadDetail001MB> root = cq.from(LeadDetail001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public LeadDetail001MB getleaddetail(int leadId) {
		LeadDetail001MB leadetail001MB = entityManager.find(LeadDetail001MB.class, leadId);
		return leadetail001MB;
	}

	public void deleteleaddetail(int leadId) {
		LeadDetail001MB leadetail001MB = entityManager.find(LeadDetail001MB.class, leadId);
		entityManager.remove(leadetail001MB);
	}
	
	//Inactive Customer
	
	public void addinactivecust(InactiveCust001MB inactivecust001MB) {
		entityManager.merge(inactivecust001MB);
	}

	@SuppressWarnings("unchecked")
	public List<InactiveCust001MB> listinactivecust() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<InactiveCust001MB> cq = builder.createQuery(InactiveCust001MB.class);
		Root<InactiveCust001MB> root = cq.from(InactiveCust001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public InactiveCust001MB getinactivecust(int inactcustId) {
		InactiveCust001MB inactivecust001MB = entityManager.find(InactiveCust001MB.class, inactcustId);
		return inactivecust001MB;
	}

	public void deleteinactivecust(int inactcustId) {
		InactiveCust001MB inactivecust001MB = entityManager.find(InactiveCust001MB.class, inactcustId);
		entityManager.remove(inactivecust001MB);
	}
	
	
	
	
	
	

}
