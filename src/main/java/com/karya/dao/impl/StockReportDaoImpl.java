package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockReportDao;
import com.karya.model.StkRepAgeing001MB;
import com.karya.model.StkRepLedger001MB;
import com.karya.model.StkRepProjected001MB;
import com.karya.model.StockRepBalance001MB;

@Repository
@Transactional
public class StockReportDaoImpl implements IStockReportDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addstkrepledger(StkRepLedger001MB stkrepledger001MB) {
		entityManager.merge(stkrepledger001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StkRepLedger001MB> liststkrepledger() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StkRepLedger001MB> cq = builder.createQuery(StkRepLedger001MB.class);
		Root<StkRepLedger001MB> root = cq.from(StkRepLedger001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StkRepLedger001MB getstkrepledger(int stledId) {
		StkRepLedger001MB stkrepledger001MB = entityManager.find(StkRepLedger001MB.class, stledId);
		return stkrepledger001MB;
	}

	public void deletestkrepledger(int stledId) {
		StkRepLedger001MB stkrepledger001MB = entityManager.find(StkRepLedger001MB.class, stledId);
		entityManager.remove(stkrepledger001MB);
	}
	
	//Stock report balance
	
	public void addstkrepbalance(StockRepBalance001MB stkrepbalance001MB) {
		entityManager.merge(stkrepbalance001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockRepBalance001MB> liststkrepbalance() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockRepBalance001MB> cq = builder.createQuery(StockRepBalance001MB.class);
		Root<StockRepBalance001MB> root = cq.from(StockRepBalance001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockRepBalance001MB getstkrepbalance(int stbalId) {
		StockRepBalance001MB stkrepbalance001MB = entityManager.find(StockRepBalance001MB.class, stbalId);
		return stkrepbalance001MB;
	}

	public void deletestkrepbalance(int stbalId) {
		StockRepBalance001MB stkrepbalance001MB = entityManager.find(StockRepBalance001MB.class, stbalId);
		entityManager.remove(stkrepbalance001MB);
	}
	
	//Stock report projected
	
	public void addstkrepprojected(StkRepProjected001MB stkrepprojected001MB) {
		entityManager.merge(stkrepprojected001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StkRepProjected001MB> liststkrepprojected() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StkRepProjected001MB> cq = builder.createQuery(StkRepProjected001MB.class);
		Root<StkRepProjected001MB> root = cq.from(StkRepProjected001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StkRepProjected001MB getstkrepprojected(int stprojId) {
		StkRepProjected001MB stkrepprojected001MB = entityManager.find(StkRepProjected001MB.class, stprojId);
		return stkrepprojected001MB;
	}

	public void deletestkrepprojected(int stprojId) {
		StkRepProjected001MB stkrepprojected001MB = entityManager.find(StkRepProjected001MB.class, stprojId);
		entityManager.remove(stkrepprojected001MB);
	}
	
	//Stock Report Ageing
	
	public void addstkrepageing(StkRepAgeing001MB stkrepageing001MB) {
		entityManager.merge(stkrepageing001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StkRepAgeing001MB> liststkrepageing() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StkRepAgeing001MB> cq = builder.createQuery(StkRepAgeing001MB.class);
		Root<StkRepAgeing001MB> root = cq.from(StkRepAgeing001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StkRepAgeing001MB getstkrepageing(int stageId) {
		StkRepAgeing001MB stkrepageing001MB = entityManager.find(StkRepAgeing001MB.class, stageId);
		return stkrepageing001MB;
	}

	public void deletestkrepageing(int stageId) {
		StkRepAgeing001MB stkrepageing001MB = entityManager.find(StkRepAgeing001MB.class, stageId);
		entityManager.remove(stkrepageing001MB);
	}
	
	
	
	
	
	

}
