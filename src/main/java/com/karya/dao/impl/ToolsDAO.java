package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IToolsDAO;
import com.karya.model.AssetMovement001MB;
import com.karya.model.ChequeTemplate001MB;
import com.karya.model.PeriodClosingVoucher001MB;

@Repository
@Transactional
public class ToolsDAO implements IToolsDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* Period Closing Voucher */
	
	public void addperiodclosingvoucher(PeriodClosingVoucher001MB periodclosingvouchermb) {
		entityManager.merge(periodclosingvouchermb);
	}
	
	@SuppressWarnings("unchecked")
	public List<PeriodClosingVoucher001MB> periodclosingvoucherlist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PeriodClosingVoucher001MB> cq = builder.createQuery(PeriodClosingVoucher001MB.class);
		Root<PeriodClosingVoucher001MB> root = cq.from(PeriodClosingVoucher001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public PeriodClosingVoucher001MB getperiodclosingvoucher(int id) {
		PeriodClosingVoucher001MB periodclosingvouchermb = entityManager.find(PeriodClosingVoucher001MB.class, id);
		return periodclosingvouchermb;
	}

	public void deleteperiodclosingvoucher(int id) {
		PeriodClosingVoucher001MB periodclosingvouchermb = entityManager.find(PeriodClosingVoucher001MB.class, id);
		entityManager.remove(periodclosingvouchermb);
	}
	
	/* Asset Movement */
	

	public void addassetmovement(AssetMovement001MB assetmovementmb) {
		entityManager.merge(assetmovementmb);
	}
	
	@SuppressWarnings("unchecked")
	public List<AssetMovement001MB> assetmovementlist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AssetMovement001MB> cq = builder.createQuery(AssetMovement001MB.class);
		Root<AssetMovement001MB> root = cq.from(AssetMovement001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public AssetMovement001MB getassetmovement(int id) {
		AssetMovement001MB assetmovementmb = entityManager.find(AssetMovement001MB.class, id);
		return assetmovementmb;
	}

	public void deleteassetmovement(int id) {
		AssetMovement001MB assetmovementmb = entityManager.find(AssetMovement001MB.class, id);
		entityManager.remove(assetmovementmb);
	}
	
	//cheque template
	
	public void addchequetemplate(ChequeTemplate001MB chequetemplate001mb) {
		entityManager.merge(chequetemplate001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<ChequeTemplate001MB> listchequetemplate() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ChequeTemplate001MB> cq = builder.createQuery(ChequeTemplate001MB.class);
		Root<ChequeTemplate001MB> root = cq.from(ChequeTemplate001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public ChequeTemplate001MB getchequetemplate(int cheqId) {
		ChequeTemplate001MB chequetemplate001mb = entityManager.find(ChequeTemplate001MB.class, cheqId);
		return chequetemplate001mb;
	}

	public void deletechequetemplate(int cheqId) {
		ChequeTemplate001MB chequetemplate001mb = entityManager.find(ChequeTemplate001MB.class, cheqId);
		entityManager.remove(chequetemplate001mb);
	}

	


}
