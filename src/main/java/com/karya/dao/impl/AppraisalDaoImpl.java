package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAppraisalDao;
import com.karya.model.Appraisal001MB;
import com.karya.model.AppraisalTempModel001MB;

@Repository
@Transactional
public class AppraisalDaoImpl implements IAppraisalDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addappraisal(Appraisal001MB appraisal001MB) {
		entityManager.merge(appraisal001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Appraisal001MB> listappraisal() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Appraisal001MB> cq = builder.createQuery(Appraisal001MB.class);
		Root<Appraisal001MB> root = cq.from(Appraisal001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Appraisal001MB getappraisal(int apprId) {
		Appraisal001MB appraisal001MB = entityManager.find(Appraisal001MB.class, apprId);
		return appraisal001MB;
	}

	public void deleteappraisal(int apprId) {
		Appraisal001MB appraisal001MB = entityManager.find(Appraisal001MB.class, apprId);
		entityManager.remove(appraisal001MB);
	}
	
	//appraisal template
	
	public void addappraisaltemp(AppraisalTempModel001MB appraisaltemp001MB) {
		entityManager.merge(appraisaltemp001MB);
	}

	@SuppressWarnings("unchecked")
	public List<AppraisalTempModel001MB> listappraisaltemp() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AppraisalTempModel001MB> cq = builder.createQuery(AppraisalTempModel001MB.class);
		Root<AppraisalTempModel001MB> root = cq.from(AppraisalTempModel001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public AppraisalTempModel001MB getappraisaltemp(int apptmpId) {
		AppraisalTempModel001MB appraisaltemp001MB = entityManager.find(AppraisalTempModel001MB.class, apptmpId);
		return appraisaltemp001MB;
	}

	public void deleteappraisaltemp(int apptmpId) {
		AppraisalTempModel001MB appraisaltemp001MB = entityManager.find(AppraisalTempModel001MB.class, apptmpId);
		entityManager.remove(appraisaltemp001MB);
	}
	
	
	
	
	

}
