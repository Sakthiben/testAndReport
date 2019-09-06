package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMspDao;
import com.karya.model.CrmOppo001MB;
import com.karya.model.CrmspContact001MB;
import com.karya.model.CrmspCust001MB;
import com.karya.model.CrmspLead001MB;

@Repository
@Transactional
public class CRMspDaoImpl implements ICRMspDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addcrmsplead(CrmspLead001MB crmspleadl001MB) {
		entityManager.merge(crmspleadl001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CrmspLead001MB> listcrmsplead() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CrmspLead001MB> cq = builder.createQuery(CrmspLead001MB.class);
		Root<CrmspLead001MB> root = cq.from(CrmspLead001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CrmspLead001MB getcrmsplead(int slineId) {
		CrmspLead001MB crmspleadl001MB = entityManager.find(CrmspLead001MB.class, slineId);
		return crmspleadl001MB;
	}

	public void deletecrmsplead(int slineId) {
		CrmspLead001MB crmspleadl001MB = entityManager.find(CrmspLead001MB.class, slineId);
		entityManager.remove(crmspleadl001MB);
	}
	
	//CRM CONTACT
	
	public void addcrmspcontact(CrmspContact001MB crmspcontactl001MB) {
		entityManager.merge(crmspcontactl001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CrmspContact001MB> listcrmspcontact() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CrmspContact001MB> cq = builder.createQuery(CrmspContact001MB.class);
		Root<CrmspContact001MB> root = cq.from(CrmspContact001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CrmspContact001MB getcrmspcontact(int contId) {
		CrmspContact001MB crmspcontactl001MB = entityManager.find(CrmspContact001MB.class, contId);
		return crmspcontactl001MB;
	}

	public void deletecrmspcontact(int contId) {
		CrmspContact001MB crmspcontactl001MB = entityManager.find(CrmspContact001MB.class, contId);
		entityManager.remove(crmspcontactl001MB);
	}
	
	//CRM Oppo
	
	public void addcrmoppo(CrmOppo001MB crmoppol001MB) {
		entityManager.merge(crmoppol001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CrmOppo001MB> listcrmoppo() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CrmOppo001MB> cq = builder.createQuery(CrmOppo001MB.class);
		Root<CrmOppo001MB> root = cq.from(CrmOppo001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CrmOppo001MB getcrmoppo(int oppId) {
		CrmOppo001MB crmoppol001MB = entityManager.find(CrmOppo001MB.class, oppId);
		return crmoppol001MB;
	}

	public void deletecrmoppo(int oppId) {
		CrmOppo001MB crmoppol001MB = entityManager.find(CrmOppo001MB.class, oppId);
		entityManager.remove(crmoppol001MB);
	}
	
	//CRM Customer
	
	public void addcrmcust(CrmspCust001MB crmcust001MB) {
		entityManager.merge(crmcust001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CrmspCust001MB> listcrmcust() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CrmspCust001MB> cq = builder.createQuery(CrmspCust001MB.class);
		Root<CrmspCust001MB> root = cq.from(CrmspCust001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CrmspCust001MB getcrmcust(int custId) {
		CrmspCust001MB crmcust001MB = entityManager.find(CrmspCust001MB.class, custId);
		return crmcust001MB;
	}

	public void deletecrmcust(int custId) {
		CrmspCust001MB crmcust001MB = entityManager.find(CrmspCust001MB.class, custId);
		entityManager.remove(crmcust001MB);
	}
	
	
	
	
	
	
	

}
