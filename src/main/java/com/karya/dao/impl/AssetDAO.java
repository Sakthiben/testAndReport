package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAssetDAO;
import com.karya.model.Asset001MB;

@Repository
@Transactional
public class AssetDAO implements IAssetDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addasset(Asset001MB assetmb) {
		entityManager.merge(assetmb);
	}
	
	@SuppressWarnings("unchecked")
	public List<Asset001MB> assetlist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Asset001MB> cq = builder.createQuery(Asset001MB.class);
		Root<Asset001MB> root = cq.from(Asset001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public Asset001MB getAsset(int id) {
		Asset001MB assetmb = entityManager.find(Asset001MB.class, id);
		return assetmb;
	}

	public void deleteasset(int id) {
		Asset001MB assetmb = entityManager.find(Asset001MB.class, id);
		entityManager.remove(assetmb);
	}

}
