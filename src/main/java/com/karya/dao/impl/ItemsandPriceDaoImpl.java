package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemsandPriceDao;
import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemPrice001MB;
import com.karya.model.PricingRule001MB;
import com.karya.model.ProductBundle001MB;
import com.karya.model.ShippingRule001MB;

@Repository
@Transactional
public class ItemsandPriceDaoImpl implements IItemsandPriceDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void additemgroup(ItemGroup001MB itemgroup001MB) {
		entityManager.merge(itemgroup001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemGroup001MB> listitemgroup() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemGroup001MB> cq = builder.createQuery(ItemGroup001MB.class);
		Root<ItemGroup001MB> root = cq.from(ItemGroup001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemGroup001MB getitemgroup(int igId) {
		ItemGroup001MB itemgroup001MB = entityManager.find(ItemGroup001MB.class, igId);
		return itemgroup001MB;
	}

	public void deleteitemgroup(int igId) {
		ItemGroup001MB itemgroup001MB = entityManager.find(ItemGroup001MB.class, igId);
		entityManager.remove(itemgroup001MB);
	}
	
	//Item Price
	
	public void additemprice(ItemPrice001MB itemprice001MB) {
		entityManager.merge(itemprice001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemPrice001MB> listitemprice() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemPrice001MB> cq = builder.createQuery(ItemPrice001MB.class);
		Root<ItemPrice001MB> root = cq.from(ItemPrice001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemPrice001MB getitemprice(int ipId) {
		ItemPrice001MB itemprice001MB = entityManager.find(ItemPrice001MB.class, ipId);
		return itemprice001MB;
	}

	public void deleteitemprice(int ipId) {
		ItemPrice001MB itemprice001MB = entityManager.find(ItemPrice001MB.class, ipId);
		entityManager.remove(itemprice001MB);
	}
	
	//Product Bundle
	
	public void addproductbundle(ProductBundle001MB productbundle001MB) {
		entityManager.merge(productbundle001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ProductBundle001MB> listproductbundle() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductBundle001MB> cq = builder.createQuery(ProductBundle001MB.class);
		Root<ProductBundle001MB> root = cq.from(ProductBundle001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ProductBundle001MB getproductbundle(int pbundId) {
		ProductBundle001MB productbundle001MB = entityManager.find(ProductBundle001MB.class, pbundId);
		return productbundle001MB;
	}

	public void deleteproductbundle(int pbundId) {
		ProductBundle001MB productbundle001MB = entityManager.find(ProductBundle001MB.class, pbundId);
		entityManager.remove(productbundle001MB);
	}
	
	//Pricing Rule
	
	public void addpricingrule(PricingRule001MB pricingrule001MB) {
		entityManager.merge(pricingrule001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PricingRule001MB> listpricingrule() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PricingRule001MB> cq = builder.createQuery(PricingRule001MB.class);
		Root<PricingRule001MB> root = cq.from(PricingRule001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PricingRule001MB getpricingrule(int priceruleid) {
		PricingRule001MB pricingrule001MB = entityManager.find(PricingRule001MB.class, priceruleid);
		return pricingrule001MB;
	}

	public void deletepricingrule(int priceruleid) {
		PricingRule001MB pricingrule001MB = entityManager.find(PricingRule001MB.class, priceruleid);
		entityManager.remove(pricingrule001MB);
	}
	
	//Shipping Rule
	
		public void addshippingrule(ShippingRule001MB shippingrule001MB) {
			entityManager.merge(shippingrule001MB);
		}

		@SuppressWarnings("unchecked")
		public List<ShippingRule001MB> listshippingrule() {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ShippingRule001MB> cq = builder.createQuery(ShippingRule001MB.class);
			Root<ShippingRule001MB> root = cq.from(ShippingRule001MB.class);
			cq.select(root);
			return entityManager.createQuery(cq).getResultList();
		}

		public ShippingRule001MB getshippingrule(int sruleId) {
			ShippingRule001MB shippingrule001MB = entityManager.find(ShippingRule001MB.class, sruleId);
			return shippingrule001MB;
		}

		public void deleteshippingrule(int sruleId) {
			ShippingRule001MB shippingrule001MB = entityManager.find(ShippingRule001MB.class, sruleId);
			entityManager.remove(shippingrule001MB);
		}
		
	
	
	
	
	
	
	

}
