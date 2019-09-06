package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBuyAnalyticsDao;
import com.karya.model.PuOrderTrend001MB;
import com.karya.model.PurchaseAnalytics001MB;
import com.karya.model.SupplierWiseAnalytics001MB;

@Repository
@Transactional
public class BuyAnalyticsDaoImpl implements IBuyAnalyticsDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addpuanalytics(PurchaseAnalytics001MB purchaseanalytics001MB) {
		entityManager.merge(purchaseanalytics001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseAnalytics001MB> listpuanalytics() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PurchaseAnalytics001MB> cq = builder.createQuery(PurchaseAnalytics001MB.class);
		Root<PurchaseAnalytics001MB> root = cq.from(PurchaseAnalytics001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PurchaseAnalytics001MB getpuanalytics(int puansId) {
		PurchaseAnalytics001MB purchaseanalytics001MB = entityManager.find(PurchaseAnalytics001MB.class, puansId);
		return purchaseanalytics001MB;
	}

	public void deletepuanalytics(int puansId) {
		PurchaseAnalytics001MB purchaseanalytics001MB = entityManager.find(PurchaseAnalytics001MB.class, puansId);
		entityManager.remove(purchaseanalytics001MB);
	}
	
	//pur order trend
	
	public void addpuordtrend(PuOrderTrend001MB puordertrend001MB) {
		entityManager.merge(puordertrend001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PuOrderTrend001MB> listpuordtrend() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PuOrderTrend001MB> cq = builder.createQuery(PuOrderTrend001MB.class);
		Root<PuOrderTrend001MB> root = cq.from(PuOrderTrend001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PuOrderTrend001MB getpuordtrend(int ptrId) {
		PuOrderTrend001MB puordertrend001MB = entityManager.find(PuOrderTrend001MB.class, ptrId);
		return puordertrend001MB;
	}

	public void deletepuordtrend(int ptrId) {
		PuOrderTrend001MB puordertrend001MB = entityManager.find(PuOrderTrend001MB.class, ptrId);
		entityManager.remove(puordertrend001MB);
	}
	
	//Sales Wise puorder
	
	public void addswsanalytics(SupplierWiseAnalytics001MB supplierwiseanalytics001MB) {
		entityManager.merge(supplierwiseanalytics001MB);
	}

	@SuppressWarnings("unchecked")
	public List<SupplierWiseAnalytics001MB> listswsanalytics() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SupplierWiseAnalytics001MB> cq = builder.createQuery(SupplierWiseAnalytics001MB.class);
		Root<SupplierWiseAnalytics001MB> root = cq.from(SupplierWiseAnalytics001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public SupplierWiseAnalytics001MB getswsanalytics(int swsId) {
		SupplierWiseAnalytics001MB supplierwiseanalytics001MB = entityManager.find(SupplierWiseAnalytics001MB.class, swsId);
		return supplierwiseanalytics001MB;
	}

	public void deleteswsanalytics(int swsId) {
		SupplierWiseAnalytics001MB supplierwiseanalytics001MB = entityManager.find(SupplierWiseAnalytics001MB.class, swsId);
		entityManager.remove(supplierwiseanalytics001MB);
	}
	
	
	
	
}
