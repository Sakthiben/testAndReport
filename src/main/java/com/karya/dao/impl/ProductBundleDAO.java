package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProductBundleDAO;
import com.karya.model.ProductBundle001MB;

@Repository
@Transactional
public class ProductBundleDAO implements IProductBundleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addproductbundle(ProductBundle001MB productbundlemb) {
		entityManager.merge(productbundlemb);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductBundle001MB> productbundlelist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductBundle001MB> cq = builder.createQuery(ProductBundle001MB.class);
		Root<ProductBundle001MB> root = cq.from(ProductBundle001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public ProductBundle001MB getProductbundle(int id) {
		ProductBundle001MB productbundlemb = entityManager.find(ProductBundle001MB.class, id);
		return productbundlemb;
	}

	public void deleteproductbundle(int id) {
		ProductBundle001MB productbundlemb = entityManager.find(ProductBundle001MB.class, id);
		entityManager.remove(productbundlemb);
	}


}
