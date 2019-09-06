package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockEntryDAO;
import com.karya.model.StockEntry001MB;


@Repository
@Transactional
public class StockEntryDaoImpl implements IStockEntryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<StockEntry001MB> liststockentry() {
	
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockEntry001MB> cq = builder.createQuery(StockEntry001MB.class);
		Root<StockEntry001MB> root = cq.from(StockEntry001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	
	}

	@Override
	public void addstock(StockEntry001MB stock) {
	  entityManager.merge(stock);
	}

	@Override
	public StockEntry001MB getstockdetails(int stockid) {
		StockEntry001MB stock = entityManager.find(StockEntry001MB.class, stockid);
		return stock;

	}

	@Override
	public void deletestockdetails(int stockid) {
		
		StockEntry001MB stock  = entityManager.find(StockEntry001MB.class,stockid);
		entityManager.remove(stock);	
		
	}
	
	
}

