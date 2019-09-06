package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockTransactionDao;
import com.karya.model.StockTransDelivery001MB;
import com.karya.model.StockTransEntry001MB;
import com.karya.model.StockTransPurRecpt001MB;

@Repository
@Transactional
public class StockTransactionDaoImpl implements IStockTransactionDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addstocktransentry(StockTransEntry001MB stocktransentry001MB) {
		entityManager.merge(stocktransentry001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockTransEntry001MB> liststocktransentry() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockTransEntry001MB> cq = builder.createQuery(StockTransEntry001MB.class);
		Root<StockTransEntry001MB> root = cq.from(StockTransEntry001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockTransEntry001MB getstocktransentry(int stentid) {
		StockTransEntry001MB stocktransentry001MB = entityManager.find(StockTransEntry001MB.class, stentid);
		return stocktransentry001MB;
	}

	public void deletestocktransentry(int stentid) {
		StockTransEntry001MB stocktransentry001MB = entityManager.find(StockTransEntry001MB.class, stentid);
		entityManager.remove(stocktransentry001MB);
	}
	
	//Stock Trans Delivery Note
	
	public void addstocktransdelivery(StockTransDelivery001MB stocktransdelivery001MB) {
		entityManager.merge(stocktransdelivery001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockTransDelivery001MB> liststocktransdelivery() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockTransDelivery001MB> cq = builder.createQuery(StockTransDelivery001MB.class);
		Root<StockTransDelivery001MB> root = cq.from(StockTransDelivery001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockTransDelivery001MB getstocktransdelivery(int stdelId) {
		StockTransDelivery001MB stocktransdelivery001MB = entityManager.find(StockTransDelivery001MB.class, stdelId);
		return stocktransdelivery001MB;
	}

	public void deletestocktransdelivery(int stdelId) {
		StockTransDelivery001MB stocktransdelivery001MB = entityManager.find(StockTransDelivery001MB.class, stdelId);
		entityManager.remove(stocktransdelivery001MB);
	}
	
	//Stock purchase receipt
	
	public void addstocktranspurreceipt(StockTransPurRecpt001MB stocktranspurrecpt001MB) {
		entityManager.merge(stocktranspurrecpt001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockTransPurRecpt001MB> liststocktranspurreceipt() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockTransPurRecpt001MB> cq = builder.createQuery(StockTransPurRecpt001MB.class);
		Root<StockTransPurRecpt001MB> root = cq.from(StockTransPurRecpt001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockTransPurRecpt001MB getstocktranspurreceipt(int stpurtId) {
		StockTransPurRecpt001MB stocktranspurrecpt001MB = entityManager.find(StockTransPurRecpt001MB.class, stpurtId);
		return stocktranspurrecpt001MB;
	}

	public void deletestocktranspurreceipt(int stpurtId) {
		StockTransPurRecpt001MB stocktranspurrecpt001MB = entityManager.find(StockTransPurRecpt001MB.class, stpurtId);
		entityManager.remove(stocktranspurrecpt001MB);
	}
	
	
	

}
