package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICRMSetupDao;
import com.karya.model.Communication001MB;
import com.karya.model.CustomerGroup001MB;
import com.karya.model.Territory001MB;

@Repository
@Transactional
public class CRMSetupDaoImpl implements ICRMSetupDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addcommunication(Communication001MB communication001MB) {
		entityManager.merge(communication001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Communication001MB> listcommunication() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Communication001MB> cq = builder.createQuery(Communication001MB.class);
		Root<Communication001MB> root = cq.from(Communication001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Communication001MB getcommunication(int commId) {
		Communication001MB communication001MB = entityManager.find(Communication001MB.class, commId);
		return communication001MB;
	}

	public void deletecommunication(int commId) {
		Communication001MB communication001MB = entityManager.find(Communication001MB.class, commId);
		entityManager.remove(communication001MB);
	}
	
	//Customer group
	
	public void addcustgroup(CustomerGroup001MB custGroup001MB) {
		entityManager.merge(custGroup001MB);
	}

	@SuppressWarnings("unchecked")
	public List<CustomerGroup001MB> listcustgroup() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerGroup001MB> cq = builder.createQuery(CustomerGroup001MB.class);
		Root<CustomerGroup001MB> root = cq.from(CustomerGroup001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CustomerGroup001MB getcustgroup(int cugrpId) {
		CustomerGroup001MB custGroup001MB = entityManager.find(CustomerGroup001MB.class, cugrpId);
		return custGroup001MB;
	}

	public void deletecustgroup(int cugrpId) {
		CustomerGroup001MB custGroup001MB = entityManager.find(CustomerGroup001MB.class, cugrpId);
		entityManager.remove(custGroup001MB);
	}
	
	//Territory
	
	public void addterritory(Territory001MB territory001MB) {
		entityManager.merge(territory001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Territory001MB> listterritory() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Territory001MB> cq = builder.createQuery(Territory001MB.class);
		Root<Territory001MB> root = cq.from(Territory001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Territory001MB getterritory(int terId) {
		Territory001MB territory001MB = entityManager.find(Territory001MB.class, terId);
		return territory001MB;
	}

	public void deleteterritory(int terId) {
		Territory001MB territory001MB = entityManager.find(Territory001MB.class, terId);
		entityManager.remove(territory001MB);
	}
	
	
	
	
	
	

}
