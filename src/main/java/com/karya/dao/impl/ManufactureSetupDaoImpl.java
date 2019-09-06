package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IManufactureSetupDao;
import com.karya.model.ManufactureSetup001MB;

@Repository
@Transactional
public class ManufactureSetupDaoImpl implements IManufactureSetupDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addmanufacturesetup(ManufactureSetup001MB manufacturesetup001MB) {
		entityManager.merge(manufacturesetup001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ManufactureSetup001MB> listmanufacturesetup() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ManufactureSetup001MB> cq = builder.createQuery(ManufactureSetup001MB.class);
		Root<ManufactureSetup001MB> root = cq.from(ManufactureSetup001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ManufactureSetup001MB getmanufacturesetup(int mansetId) {
		ManufactureSetup001MB manufacturesetup001MB = entityManager.find(ManufactureSetup001MB.class, mansetId);
		return manufacturesetup001MB;
	}

	public void deletemanufacturesetup(int mansetId) {
		ManufactureSetup001MB manufacturesetup001MB = entityManager.find(ManufactureSetup001MB.class, mansetId);
		entityManager.remove(manufacturesetup001MB);
	}

}
