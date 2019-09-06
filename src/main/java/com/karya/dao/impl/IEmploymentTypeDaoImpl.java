package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IEmploymentTypeDao;
import com.karya.model.Branch001MB;
import com.karya.model.Designation001MB;
import com.karya.model.EmploymentType001MB;

@Repository
@Transactional
public class IEmploymentTypeDaoImpl implements IEmploymentTypeDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addEmploymentType(EmploymentType001MB employmenttype001MB) {
		entityManager.merge(employmenttype001MB);
	}

	@SuppressWarnings("unchecked")
	public List<EmploymentType001MB> listEmploymenttype() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmploymentType001MB> cq = builder.createQuery(EmploymentType001MB.class);
		Root<EmploymentType001MB> root = cq.from(EmploymentType001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public EmploymentType001MB getEmploymenttype(int etypeId) {
		EmploymentType001MB employmenttype001MB = entityManager.find(EmploymentType001MB.class, etypeId);
		return employmenttype001MB;
	}

	public void deleteEmploymenttype(int etypeId) {
		EmploymentType001MB employmenttype001MB = entityManager.find(EmploymentType001MB.class, etypeId);
		entityManager.remove(employmenttype001MB);
	}
	
	public void addbranch(Branch001MB branch001MB) {
		entityManager.merge(branch001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Branch001MB> listbranch() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Branch001MB> cq = builder.createQuery(Branch001MB.class);
		Root<Branch001MB> root = cq.from(Branch001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Branch001MB getbranch(int branchId) {
		Branch001MB branch001MB = entityManager.find(Branch001MB.class, branchId);
		return branch001MB;
	}

	public void deletebranch(int branchId) {
		Branch001MB branch001MB = entityManager.find(Branch001MB.class, branchId);
		entityManager.remove(branch001MB);
	}
	
	public void adddesignation(Designation001MB designation001MB) {
		entityManager.merge(designation001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Designation001MB> listdesignation() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Designation001MB> cq = builder.createQuery(Designation001MB.class);
		Root<Designation001MB> root = cq.from(Designation001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Designation001MB getdesignation(int designId) {
		Designation001MB designation001MB = entityManager.find(Designation001MB.class, designId);
		return designation001MB;
	}

	public void deletedesignation(int designId) {
		Designation001MB designation001MB = entityManager.find(Designation001MB.class, designId);
		entityManager.remove(designation001MB);
	}



}
