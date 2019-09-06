package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemdtDAO;
import com.karya.model.Itemdt001MB;
import com.karya.model.Order001MB;
import com.karya.model.SalesOrder001MB;


@Repository
@Transactional
public class ItemdtDAO implements IItemdtDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void itemdtAddAction(Itemdt001MB  itemdt001MB) {
		
		entityManager.merge(itemdt001MB);
	}
	
	public void soAdd(SalesOrder001MB salesOrder){
		if(salesOrder.getSalesId() == 0) {
			entityManager.persist(salesOrder);
		} else {
			entityManager.merge(salesOrder);
		}
	}
	public Itemdt001MB itemdtEditAction(int itemId) {
		Itemdt001MB itemdt001MB = entityManager.find(Itemdt001MB.class, itemId);
		return itemdt001MB;
	}
	
	public SalesOrder001MB soEdit(int salesId){
		SalesOrder001MB salesOrder = entityManager.find(SalesOrder001MB.class, salesId);
		return(salesOrder);
	}
	
	public void itemDeleteAction(int itemId){
		Itemdt001MB itemdt001MB = entityManager.find(Itemdt001MB.class,itemId);
		entityManager.remove(itemdt001MB);
	}
	
	public void soDelete(int salesId){
		SalesOrder001MB salesOrder = entityManager.find(SalesOrder001MB.class, salesId);
		entityManager.remove(salesOrder);
	}
	@SuppressWarnings("unused")
	@Override
	public void orderAdd(Order001MB order001mb){
		entityManager.merge(order001mb);
	}
	
	public Order001MB orderEdit(int orderId){
		Order001MB order001mb = entityManager.find(Order001MB.class, orderId);
				return order001mb;
	}
	
	public void orderDelete(int orderId){
		Order001MB order001mb = entityManager.find(Order001MB.class, orderId);
		entityManager.remove(order001mb);
	}
	
	public List<Itemdt001MB> listallItems() throws DataAccessException
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Itemdt001MB> cq=builder.createQuery(Itemdt001MB.class);
		Root<Itemdt001MB> root = cq.from(Itemdt001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();	
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SalesOrder001MB> listallSOrder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalesOrder001MB> cq = builder.createQuery(SalesOrder001MB.class);
		Root<SalesOrder001MB> root = cq.from(SalesOrder001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
		
	}
	
	public List<Order001MB> listallOrder() throws DataAccessException{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order001MB> cq = builder.createQuery(Order001MB.class);
		Root<Order001MB> root = cq.from(Order001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
		
	}
}
