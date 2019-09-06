package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IOpenProductionOrderDao;
import com.karya.model.BomType001MB;
import com.karya.model.CompletePROrder001MB;
import com.karya.model.IssuedItem001MB;
import com.karya.model.OpenProductionOrder001MB;
import com.karya.model.ProgPROrder001MB;

@Repository
@Transactional
public class OpenProductionOrderDaoImpl implements IOpenProductionOrderDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addopenprodoerder(OpenProductionOrder001MB openproductionorder001mb) {
		entityManager.merge(openproductionorder001mb);
	}

	@SuppressWarnings("unchecked")
	public List<OpenProductionOrder001MB> listopenprodoerder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OpenProductionOrder001MB> cq = builder.createQuery(OpenProductionOrder001MB.class);
		Root<OpenProductionOrder001MB> root = cq.from(OpenProductionOrder001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public OpenProductionOrder001MB getopenprodoerder(int prodId) {
		OpenProductionOrder001MB openproductionorder001mb = entityManager.find(OpenProductionOrder001MB.class, prodId);
		return openproductionorder001mb;
	}

	public void deleteopenprodoerder(int prodId) {
		OpenProductionOrder001MB openproductionorder001mb = entityManager.find(OpenProductionOrder001MB.class, prodId);
		entityManager.remove(openproductionorder001mb);
	}
	
	//Progress Production Order
	
	public void addprogprodoerder(ProgPROrder001MB progprorder001mb) {
		entityManager.merge(progprorder001mb);
	}

	@SuppressWarnings("unchecked")
	public List<ProgPROrder001MB> listprogprodoerder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProgPROrder001MB> cq = builder.createQuery(ProgPROrder001MB.class);
		Root<ProgPROrder001MB> root = cq.from(ProgPROrder001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ProgPROrder001MB getprogprodoerder(int prodId) {
		ProgPROrder001MB completeprorder001mb = entityManager.find(ProgPROrder001MB.class, prodId);
		return completeprorder001mb;
	}

	public void deleteprogprodoerder(int prodId) {
		ProgPROrder001MB completeprorder001mb = entityManager.find(ProgPROrder001MB.class, prodId);
		entityManager.remove(completeprorder001mb);
	}
	//
	public void addcompprodoerder(CompletePROrder001MB completeprorder001mb) {
		entityManager.merge(completeprorder001mb);
	}

	@SuppressWarnings("unchecked")
	public List<CompletePROrder001MB> listcompprodoerder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CompletePROrder001MB> cq = builder.createQuery(CompletePROrder001MB.class);
		Root<CompletePROrder001MB> root = cq.from(CompletePROrder001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CompletePROrder001MB getcompprodoerder(int prodId) {
		CompletePROrder001MB completeprorder001mb = entityManager.find(CompletePROrder001MB.class, prodId);
		return completeprorder001mb;
	}

	public void deletecompprodoerder(int prodId) {
		CompletePROrder001MB completeprorder001mb = entityManager.find(CompletePROrder001MB.class, prodId);
		entityManager.remove(completeprorder001mb);
	}
	
	//Issued Item
	
	public void addissuedItem(IssuedItem001MB issueditem001mb) {
		entityManager.merge(issueditem001mb);
	}

	@SuppressWarnings("unchecked")
	public List<IssuedItem001MB> listissuedItem() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<IssuedItem001MB> cq = builder.createQuery(IssuedItem001MB.class);
		Root<IssuedItem001MB> root = cq.from(IssuedItem001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public IssuedItem001MB getissuedItem(int issueId) {
		IssuedItem001MB issueditem001mb = entityManager.find(IssuedItem001MB.class, issueId);
		return issueditem001mb;
	}

	public void deleteissuedItem(int issueId) {
		IssuedItem001MB issueditem001mb = entityManager.find(IssuedItem001MB.class, issueId);
		entityManager.remove(issueditem001mb);
	}
	
	//BOM Type
	
	public void addbomtype(BomType001MB bomtype001mb) {
		entityManager.merge(bomtype001mb);
	}

	@SuppressWarnings("unchecked")
	public List<BomType001MB> listbomtype() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BomType001MB> cq = builder.createQuery(BomType001MB.class);
		Root<BomType001MB> root = cq.from(BomType001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public BomType001MB getbomtype(int bomId) {
		BomType001MB bomtype001mb = entityManager.find(BomType001MB.class, bomId);
		return bomtype001mb;
	}

	public void deletebomtype(int bomId) {
		BomType001MB bomtype001mb = entityManager.find(BomType001MB.class, bomId);
		entityManager.remove(bomtype001mb);
	}
	
	
	
	
	
	
	

}
