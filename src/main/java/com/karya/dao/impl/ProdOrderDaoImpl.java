package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProdOrderDao;
import com.karya.model.ProdOrder001MB;
import com.karya.model.ProdPlanning001MB;
import com.karya.model.ProdStockEntry001MB;
import com.karya.model.ProdTimeSheet001MB;

@Repository
@Transactional

public class ProdOrderDaoImpl implements IProdOrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addProdorder(ProdOrder001MB prodorder001MB) {
		entityManager.merge(prodorder001MB);
		
	}

	@SuppressWarnings("unchecked")
	public List<ProdOrder001MB> listprodorder() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProdOrder001MB> cq = builder.createQuery(ProdOrder001MB.class);
		Root<ProdOrder001MB> root = cq.from(ProdOrder001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ProdOrder001MB getprodorder(int prId) {
		ProdOrder001MB prodorder001MB = entityManager.find(ProdOrder001MB.class, prId);
		return prodorder001MB;
	}

	public void deleteprodorder(int prId) {
		ProdOrder001MB prodorder001MB = entityManager.find(ProdOrder001MB.class, prId);
		entityManager.remove(prodorder001MB);
	}
	
	//product Planning

	public void addProdplanning(ProdPlanning001MB prodplanning001MB) {
		entityManager.merge(prodplanning001MB);
		
	}

	@SuppressWarnings("unchecked")
	public List<ProdPlanning001MB> listprodplanning() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProdPlanning001MB> cq = builder.createQuery(ProdPlanning001MB.class);
		Root<ProdPlanning001MB> root = cq.from(ProdPlanning001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ProdPlanning001MB getprodplanning(int prplanId) {
		ProdPlanning001MB prodplanning001MB = entityManager.find(ProdPlanning001MB.class, prplanId);
		return prodplanning001MB;
	}

	public void deleteprodplanning(int prplanId) {
		ProdPlanning001MB prodplanning001MB = entityManager.find(ProdPlanning001MB.class, prplanId);
		entityManager.remove(prodplanning001MB);
	}
	
	//product Stock Entry

		public void addProdstockentry(ProdStockEntry001MB prodstockentry001MB) {
			entityManager.merge(prodstockentry001MB);
			
		}

		@SuppressWarnings("unchecked")
		public List<ProdStockEntry001MB> listprodstockentry() {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ProdStockEntry001MB> cq = builder.createQuery(ProdStockEntry001MB.class);
			Root<ProdStockEntry001MB> root = cq.from(ProdStockEntry001MB.class);
			cq.select(root);
			return entityManager.createQuery(cq).getResultList();
		}

		public ProdStockEntry001MB getprodstockentry(int prstockId) {
			ProdStockEntry001MB prodstockentry001MB = entityManager.find(ProdStockEntry001MB.class, prstockId);
			return prodstockentry001MB;
		}

		public void deleteprodstockentry(int prstockId) {
			ProdStockEntry001MB prodstockentry001MB = entityManager.find(ProdStockEntry001MB.class, prstockId);
			entityManager.remove(prodstockentry001MB);
		}
		
		//product Time Sheet

			public void addProdtimesheet(ProdTimeSheet001MB prodtimesheet001MB) {
					entityManager.merge(prodtimesheet001MB);
					
				}

				@SuppressWarnings("unchecked")
				public List<ProdTimeSheet001MB> listprodtimesheet() {
					CriteriaBuilder builder = entityManager.getCriteriaBuilder();
					CriteriaQuery<ProdTimeSheet001MB> cq = builder.createQuery(ProdTimeSheet001MB.class);
					Root<ProdTimeSheet001MB> root = cq.from(ProdTimeSheet001MB.class);
					cq.select(root);
					return entityManager.createQuery(cq).getResultList();
				}

				public ProdTimeSheet001MB getprodtimesheet(int prtId) {
					ProdTimeSheet001MB prodtimesheet001MB = entityManager.find(ProdTimeSheet001MB.class, prtId);
					return prodtimesheet001MB;
				}

				public void deleteprodtimesheet(int prtId) {
					ProdTimeSheet001MB prodtimesheet001MB = entityManager.find(ProdTimeSheet001MB.class, prtId);
					entityManager.remove(prodtimesheet001MB);
				}



}
