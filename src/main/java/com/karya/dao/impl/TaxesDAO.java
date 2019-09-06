package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITaxesDAO;
import com.karya.model.PurchaseRegister001MB;
import com.karya.model.PurchaseTaxChargeTemplate001MB;
import com.karya.model.SalesRegister001MB;
import com.karya.model.SalesTaxes001MB;
import com.karya.model.TaxRule001MB;

@Repository
@Transactional
public class TaxesDAO implements ITaxesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* Sales Taxes and Templates */
	
	public void addsalestaxes(SalesTaxes001MB salestaxesmb) {
		entityManager.merge(salestaxesmb);
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesTaxes001MB> listsalestaxes() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalesTaxes001MB> cq = builder.createQuery(SalesTaxes001MB.class);
		Root<SalesTaxes001MB> root = cq.from(SalesTaxes001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public SalesTaxes001MB getsalestaxes(int id) {
		SalesTaxes001MB salestaxesmb = entityManager.find(SalesTaxes001MB.class, id);
		return salestaxesmb;
	}

	public void deletesalestaxes(int id) {
		SalesTaxes001MB salestaxesmb = entityManager.find(SalesTaxes001MB.class, id);
		entityManager.remove(salestaxesmb);
	}

	/* Taxes Rule */
	
	public void addtaxrule(TaxRule001MB taxrulemb) {
		entityManager.merge(taxrulemb);
	}
	
	@SuppressWarnings("unchecked")
	public List<TaxRule001MB> listtaxrule() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TaxRule001MB> cq = builder.createQuery(TaxRule001MB.class);
		Root<TaxRule001MB> root = cq.from(TaxRule001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public TaxRule001MB gettaxrule(int id) {
		TaxRule001MB taxrulemb = entityManager.find(TaxRule001MB.class, id);
		return taxrulemb;
	}

	public void deletetaxrule(int id) {
		TaxRule001MB taxrulemb = entityManager.find(TaxRule001MB.class, id);
		entityManager.remove(taxrulemb);
	}


	//Purchase tax charge
	
	public void addpurtaxcharge(PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb) {
		entityManager.merge(purchasetaxchargetemplate001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<PurchaseTaxChargeTemplate001MB> listpurtaxcharge() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PurchaseTaxChargeTemplate001MB> cq = builder.createQuery(PurchaseTaxChargeTemplate001MB.class);
		Root<PurchaseTaxChargeTemplate001MB> root = cq.from(PurchaseTaxChargeTemplate001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public PurchaseTaxChargeTemplate001MB getpurtaxcharge(int putaxId) {
		PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb = entityManager.find(PurchaseTaxChargeTemplate001MB.class, putaxId);
		return purchasetaxchargetemplate001mb;
	}

	public void deletepurtaxcharge(int putaxId) {
		PurchaseTaxChargeTemplate001MB purchasetaxchargetemplate001mb = entityManager.find(PurchaseTaxChargeTemplate001MB.class, putaxId);
		entityManager.remove(purchasetaxchargetemplate001mb);
	}
	
	//sales register
	
	public void addsalesregister(SalesRegister001MB salesregister001mb) {
		entityManager.merge(salesregister001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesRegister001MB> listsalesregister() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalesRegister001MB> cq = builder.createQuery(SalesRegister001MB.class);
		Root<SalesRegister001MB> root = cq.from(SalesRegister001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public SalesRegister001MB getsalesregister(int regId) {
		SalesRegister001MB salesregister001mb = entityManager.find(SalesRegister001MB.class, regId);
		return salesregister001mb;
	}

	public void deletesalesregister(int regId) {
		SalesRegister001MB salesregister001mb = entityManager.find(SalesRegister001MB.class, regId);
		entityManager.remove(salesregister001mb);
	}
	
	//purchase register
	
	public void addpurchaseregister(PurchaseRegister001MB purchaseregister001mb) {
		entityManager.merge(purchaseregister001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<PurchaseRegister001MB> listpurchaseregister() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PurchaseRegister001MB> cq = builder.createQuery(PurchaseRegister001MB.class);
		Root<PurchaseRegister001MB> root = cq.from(PurchaseRegister001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public PurchaseRegister001MB getpurchaseregister(int regId) {
		PurchaseRegister001MB purchaseregister001mb = entityManager.find(PurchaseRegister001MB.class, regId);
		return purchaseregister001mb;
	}

	public void deletepurchaseregister(int regId) {
		PurchaseRegister001MB purchaseregister001mb = entityManager.find(PurchaseRegister001MB.class, regId);
		entityManager.remove(purchaseregister001mb);
	}
	
	
	
	
	
	



}
