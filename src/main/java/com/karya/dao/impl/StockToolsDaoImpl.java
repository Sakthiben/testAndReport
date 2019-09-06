package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockToolsDao;
import com.karya.model.InstallationNote001MB;
import com.karya.model.LandCostCoucher001MB;
import com.karya.model.PackingSlip001MB;
import com.karya.model.StockReconcile001MB;

@Repository
@Transactional
public class StockToolsDaoImpl implements IStockToolsDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addinstallnote(InstallationNote001MB installationnote001MB) {
		entityManager.merge(installationnote001MB);
	}

	@SuppressWarnings("unchecked")
	public List<InstallationNote001MB> listinstallnote() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<InstallationNote001MB> cq = builder.createQuery(InstallationNote001MB.class);
		Root<InstallationNote001MB> root = cq.from(InstallationNote001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public InstallationNote001MB getinstallnote(int instId) {
		InstallationNote001MB installationnote001MB = entityManager.find(InstallationNote001MB.class, instId);
		return installationnote001MB;
	}

	public void deleteinstallnote(int instId) {
		InstallationNote001MB installationnote001MB = entityManager.find(InstallationNote001MB.class, instId);
		entityManager.remove(installationnote001MB);
	}
	
	//Stock reconcile
	
	public void addstockreconcile(StockReconcile001MB stockreconcile001MB) {
		entityManager.merge(stockreconcile001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockReconcile001MB> liststockreconcile() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockReconcile001MB> cq = builder.createQuery(StockReconcile001MB.class);
		Root<StockReconcile001MB> root = cq.from(StockReconcile001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockReconcile001MB getstockreconcile(int stkrecId) {
		StockReconcile001MB stockreconcile001MB = entityManager.find(StockReconcile001MB.class, stkrecId);
		return stockreconcile001MB;
	}

	public void deletestockreconcile(int stkrecId) {
		StockReconcile001MB stockreconcile001MB = entityManager.find(StockReconcile001MB.class, stkrecId);
		entityManager.remove(stockreconcile001MB);
	}
	
	//Packing slip
	
	public void addpackingslip(PackingSlip001MB packingslip001MB) {
		entityManager.merge(packingslip001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PackingSlip001MB> listpackingslip() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PackingSlip001MB> cq = builder.createQuery(PackingSlip001MB.class);
		Root<PackingSlip001MB> root = cq.from(PackingSlip001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PackingSlip001MB getpackingslip(int psId) {
		PackingSlip001MB packingslip001MB = entityManager.find(PackingSlip001MB.class, psId);
		return packingslip001MB;
	}

	public void deletepackingslip(int psId) {
		PackingSlip001MB packingslip001MB = entityManager.find(PackingSlip001MB.class, psId);
		entityManager.remove(packingslip001MB);
	}
	
	//LAND Cost voucher
	
	public void addlandcostvoucher(LandCostCoucher001MB landcostvoucher001MB) {
		entityManager.merge(landcostvoucher001MB);
	}

	@SuppressWarnings("unchecked")
	public List<LandCostCoucher001MB> listlandcostvoucher() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LandCostCoucher001MB> cq = builder.createQuery(LandCostCoucher001MB.class);
		Root<LandCostCoucher001MB> root = cq.from(LandCostCoucher001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public LandCostCoucher001MB getlandcostvoucher(int vouchId) {
		LandCostCoucher001MB landcostvoucher001MB = entityManager.find(LandCostCoucher001MB.class, vouchId);
		return landcostvoucher001MB;
	}

	public void deletelandcostvoucher(int vouchId) {
		LandCostCoucher001MB landcostvoucher001MB = entityManager.find(LandCostCoucher001MB.class, vouchId);
		entityManager.remove(landcostvoucher001MB);
	}
	
	
	
	
	
	

}
