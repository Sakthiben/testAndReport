package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBOMDao;
import com.karya.model.ItemStatus001MB;
import com.karya.model.OperationBOM001MB;
import com.karya.model.WorkStation001MB;

@Repository
@Transactional
public class BOMDaoImpl implements IBOMDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void additemst(ItemStatus001MB itemstatus001MB) {
		entityManager.merge(itemstatus001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemStatus001MB> listitemst() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemStatus001MB> cq = builder.createQuery(ItemStatus001MB.class);
		Root<ItemStatus001MB> root = cq.from(ItemStatus001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemStatus001MB getitemst(int itemstId) {
		ItemStatus001MB itemstatus001MB = entityManager.find(ItemStatus001MB.class, itemstId);
		return itemstatus001MB;
	}

	public void deleteitemst(int itemstId) {
		ItemStatus001MB itemstatus001MB = entityManager.find(ItemStatus001MB.class, itemstId);
		entityManager.remove(itemstatus001MB);
	}
	
	//Workstation Impl
	
	public void addworkstn(WorkStation001MB workstation001MB) {
		entityManager.merge(workstation001MB);
	}

	@SuppressWarnings("unchecked")
	public List<WorkStation001MB> listworkstn() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WorkStation001MB> cq = builder.createQuery(WorkStation001MB.class);
		Root<WorkStation001MB> root = cq.from(WorkStation001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public WorkStation001MB getworkstn(int workstId) {
		WorkStation001MB workstation001MB = entityManager.find(WorkStation001MB.class, workstId);
		return workstation001MB;
	}

	public void deleteworkstn(int workstId) {
		WorkStation001MB workstation001MB = entityManager.find(WorkStation001MB.class, workstId);
		entityManager.remove(workstation001MB);
	}
	
	//Operation Impl
	
	public void addoperation(OperationBOM001MB operationbom001MB) {
		entityManager.merge(operationbom001MB);
	}

	@SuppressWarnings("unchecked")
	public List<OperationBOM001MB> listoperation() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OperationBOM001MB> cq = builder.createQuery(OperationBOM001MB.class);
		Root<OperationBOM001MB> root = cq.from(OperationBOM001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public OperationBOM001MB getoperation(int opId) {
		OperationBOM001MB operationbom001MB = entityManager.find(OperationBOM001MB.class, opId);
		return operationbom001MB;
	}

	public void deleteoperation(int opId) {
		OperationBOM001MB operationbom001MB = entityManager.find(OperationBOM001MB.class, opId);
		entityManager.remove(operationbom001MB);
	}
	
	
	
	
	
	
	

}
