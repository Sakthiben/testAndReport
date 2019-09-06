package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ISupplierDao;
import com.karya.model.Supplier001MB;
import com.karya.model.SupplierStatus001MB;
import com.karya.model.SupplierType001MB;

@Repository
@Transactional
public class SupplierDaoImpl implements ISupplierDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addsupplier(Supplier001MB supplier001MB) {
		entityManager.merge(supplier001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Supplier001MB> listsupplier() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Supplier001MB> cq = builder.createQuery(Supplier001MB.class);
		Root<Supplier001MB> root = cq.from(Supplier001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Supplier001MB getsupplier(int supId) {
		Supplier001MB supplier001MB = entityManager.find(Supplier001MB.class, supId);
		return supplier001MB;
	}

	public void deletesupplier(int supId) {
		Supplier001MB supplier001MB = entityManager.find(Supplier001MB.class, supId);
		entityManager.remove(supplier001MB);
	}
	
	//Supplier type
	
	public void addsuppliertype(SupplierType001MB suppliertype001MB) {
		entityManager.merge(suppliertype001MB);
	}

	@SuppressWarnings("unchecked")
	public List<SupplierType001MB> listsuppliertype() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SupplierType001MB> cq = builder.createQuery(SupplierType001MB.class);
		Root<SupplierType001MB> root = cq.from(SupplierType001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public SupplierType001MB getsuppliertype(int sutypeId) {
		SupplierType001MB suppliertype001MB = entityManager.find(SupplierType001MB.class, sutypeId);
		return suppliertype001MB;
	}

	public void deletesuppliertype(int sutypeId) {
		SupplierType001MB suppliertype001MB = entityManager.find(SupplierType001MB.class, sutypeId);
		entityManager.remove(suppliertype001MB);
	}
	
	//Supplier Status
	
	public void addsupplierstat(SupplierStatus001MB supplierstat001MB) {
		entityManager.merge(supplierstat001MB);
	}

	@SuppressWarnings("unchecked")
	public List<SupplierStatus001MB> listsupplierstat() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SupplierStatus001MB> cq = builder.createQuery(SupplierStatus001MB.class);
		Root<SupplierStatus001MB> root = cq.from(SupplierStatus001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public SupplierStatus001MB getsupplierstat(int sustatusId) {
		SupplierStatus001MB supplierstat001MB = entityManager.find(SupplierStatus001MB.class, sustatusId);
		return supplierstat001MB;
	}

	public void deletesupplierstat(int sustatusId) {
		SupplierStatus001MB supplierstat001MB = entityManager.find(SupplierStatus001MB.class, sustatusId);
		entityManager.remove(supplierstat001MB);
	}
	
	
	
	
	
	
	

}
