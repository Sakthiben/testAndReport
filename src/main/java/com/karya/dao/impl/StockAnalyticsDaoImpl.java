package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockAnalyticsDao;
import com.karya.model.DeliveryNoteTrend001MB;
import com.karya.model.PURecptTrend001MB;

@Repository
@Transactional
public class StockAnalyticsDaoImpl implements IStockAnalyticsDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void adddelnotetrends(DeliveryNoteTrend001MB deliverynotetrend001MB) {
		entityManager.merge(deliverynotetrend001MB);
	}

	@SuppressWarnings("unchecked")
	public List<DeliveryNoteTrend001MB> listdelnotetrends() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<DeliveryNoteTrend001MB> cq = builder.createQuery(DeliveryNoteTrend001MB.class);
		Root<DeliveryNoteTrend001MB> root = cq.from(DeliveryNoteTrend001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public DeliveryNoteTrend001MB getdelnotetrends(int dntrendId) {
		DeliveryNoteTrend001MB deliverynotetrend001MB = entityManager.find(DeliveryNoteTrend001MB.class, dntrendId);
		return deliverynotetrend001MB;
	}

	public void deletedelnotetrends(int dntrendId) {
		DeliveryNoteTrend001MB deliverynotetrend001MB = entityManager.find(DeliveryNoteTrend001MB.class, dntrendId);
		entityManager.remove(deliverynotetrend001MB);
	}
	
	//Purchase receipt
	
	public void addpurecpttrend(PURecptTrend001MB purecpttrend001MB) {
		entityManager.merge(purecpttrend001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PURecptTrend001MB> listpurecpttrend() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PURecptTrend001MB> cq = builder.createQuery(PURecptTrend001MB.class);
		Root<PURecptTrend001MB> root = cq.from(PURecptTrend001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PURecptTrend001MB getpurecpttrend(int putrendId) {
		PURecptTrend001MB purecpttrend001MB = entityManager.find(PURecptTrend001MB.class, putrendId);
		return purecpttrend001MB;
	}

	public void deletepurecpttrend(int putrendId) {
		PURecptTrend001MB purecpttrend001MB = entityManager.find(PURecptTrend001MB.class, putrendId);
		entityManager.remove(purecpttrend001MB);
	}
	
	
	
	
	
	

}
