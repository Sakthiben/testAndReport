package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ILeadDAO;
import com.karya.model.Lead001MB;



@Repository
@Transactional
public class LeadDaoImpl implements ILeadDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Lead001MB> listleaddetails() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Lead001MB> cq = builder.createQuery(Lead001MB.class);
		Root<Lead001MB> root = cq.from(Lead001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();	
	}

	@Override
	public void addleaddetails(Lead001MB lead) {
	entityManager.merge(lead);
		
	}

	@Override
	public Lead001MB getleaddetails(int id) {
		
		Lead001MB lead = entityManager.find(Lead001MB.class,id);
		return lead;
		
	}

	@Override
	public void deleteleaddetails(int id) {
		
		Lead001MB lead  = entityManager.find(Lead001MB.class,id);
		entityManager.remove(lead);		
	}
	
	
	
}
