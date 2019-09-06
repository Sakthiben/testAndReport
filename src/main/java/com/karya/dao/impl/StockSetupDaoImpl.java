package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IStockSetupDao;
import com.karya.model.Brand001MB;
import com.karya.model.StockSettings001MB;
import com.karya.model.UnitofMeasures001MB;
import com.karya.model.Warehouse001MB;

@Repository
@Transactional
public class StockSetupDaoImpl implements IStockSetupDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addstocksettings(StockSettings001MB stocksettings001MB) {
		entityManager.merge(stocksettings001MB);
	}

	@SuppressWarnings("unchecked")
	public List<StockSettings001MB> liststocksettings() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StockSettings001MB> cq = builder.createQuery(StockSettings001MB.class);
		Root<StockSettings001MB> root = cq.from(StockSettings001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public StockSettings001MB getstocksettings(int setId) {
		StockSettings001MB stocksettings001MB = entityManager.find(StockSettings001MB.class, setId);
		return stocksettings001MB;
	}

	public void deletestocksettings(int setId) {
		StockSettings001MB stocksettings001MB = entityManager.find(StockSettings001MB.class, setId);
		entityManager.remove(stocksettings001MB);
	}
	
	//Warehouse
	
	public void addwarehouse(Warehouse001MB warehouse001MB) {
		entityManager.merge(warehouse001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Warehouse001MB> listwarehouse() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Warehouse001MB> cq = builder.createQuery(Warehouse001MB.class);
		Root<Warehouse001MB> root = cq.from(Warehouse001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Warehouse001MB getwarehouse(int whId) {
		Warehouse001MB warehouse001MB = entityManager.find(Warehouse001MB.class, whId);
		return warehouse001MB;
	}

	public void deletewarehouse(int whId) {
		Warehouse001MB warehouse001MB = entityManager.find(Warehouse001MB.class, whId);
		entityManager.remove(warehouse001MB);
	}
	
	//Brand
	
	public void addbrand(Brand001MB brand001MB) {
		entityManager.merge(brand001MB);
	}

	@SuppressWarnings("unchecked")
	public List<Brand001MB> listbrand() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Brand001MB> cq = builder.createQuery(Brand001MB.class);
		Root<Brand001MB> root = cq.from(Brand001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public Brand001MB getbrand(int brandId) {
		Brand001MB brand001MB = entityManager.find(Brand001MB.class, brandId);
		return brand001MB;
	}

	public void deletebrand(int brandId) {
		Brand001MB brand001MB = entityManager.find(Brand001MB.class, brandId);
		entityManager.remove(brand001MB);
	}
	
	//unit of measures
	
	public void addunitofmeasure(UnitofMeasures001MB unitofmeasure001MB) {
		entityManager.merge(unitofmeasure001MB);
	}

	@SuppressWarnings("unchecked")
	public List<UnitofMeasures001MB> listunitofmeasure() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UnitofMeasures001MB> cq = builder.createQuery(UnitofMeasures001MB.class);
		Root<UnitofMeasures001MB> root = cq.from(UnitofMeasures001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public UnitofMeasures001MB getunitofmeasure(int unitId) {
		UnitofMeasures001MB unitofmeasure001MB = entityManager.find(UnitofMeasures001MB.class, unitId);
		return unitofmeasure001MB;
	}

	public void deleteunitofmeasure(int unitId) {
		UnitofMeasures001MB unitofmeasure001MB = entityManager.find(UnitofMeasures001MB.class, unitId);
		entityManager.remove(unitofmeasure001MB);
	}
	
	
	

}
