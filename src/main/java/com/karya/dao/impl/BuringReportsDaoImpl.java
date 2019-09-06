package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IBuyingReportsDao;
import com.karya.model.MaterialReqnotCreate001MB;
import com.karya.model.PuItemHistory001MB;
import com.karya.model.ReqItemOrdBuy001MB;
import com.karya.model.RequestedItemBuy001MB;

@Repository
@Transactional
public class BuringReportsDaoImpl implements IBuyingReportsDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addmatreqnotcreate(MaterialReqnotCreate001MB materialreqnotcreate001MB) {
		entityManager.merge(materialreqnotcreate001MB);
	}

	@SuppressWarnings("unchecked")
	public List<MaterialReqnotCreate001MB> listmatreqnotcreate() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MaterialReqnotCreate001MB> cq = builder.createQuery(MaterialReqnotCreate001MB.class);
		Root<MaterialReqnotCreate001MB> root = cq.from(MaterialReqnotCreate001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public MaterialReqnotCreate001MB getmatreqnotcreate(int mrsId) {
		MaterialReqnotCreate001MB materialreqnotcreate001MB = entityManager.find(MaterialReqnotCreate001MB.class, mrsId);
		return materialreqnotcreate001MB;
	}

	public void deletematreqnotcreate(int mrsId) {
		MaterialReqnotCreate001MB materialreqnotcreate001MB = entityManager.find(MaterialReqnotCreate001MB.class, mrsId);
		entityManager.remove(materialreqnotcreate001MB);
	}
	
	//req item ord buy
	
	public void addreqitemordbuy(ReqItemOrdBuy001MB reqitemordbuy001MB) {
		entityManager.merge(reqitemordbuy001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ReqItemOrdBuy001MB> listreqitemordbuy() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ReqItemOrdBuy001MB> cq = builder.createQuery(ReqItemOrdBuy001MB.class);
		Root<ReqItemOrdBuy001MB> root = cq.from(ReqItemOrdBuy001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ReqItemOrdBuy001MB getreqitemordbuy(int mrsId) {
		ReqItemOrdBuy001MB reqitemordbuy001MB = entityManager.find(ReqItemOrdBuy001MB.class, mrsId);
		return reqitemordbuy001MB;
	}

	public void deletereqitemordbuy(int mrsId) {
		ReqItemOrdBuy001MB reqitemordbuy001MB = entityManager.find(ReqItemOrdBuy001MB.class, mrsId);
		entityManager.remove(reqitemordbuy001MB);
	}
	
	//req item buy 
	

	public void addreqitembuy(RequestedItemBuy001MB requseteditembuy001MB) {
		entityManager.merge(requseteditembuy001MB);
	}

	@SuppressWarnings("unchecked")
	public List<RequestedItemBuy001MB> listreqitembuy() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RequestedItemBuy001MB> cq = builder.createQuery(RequestedItemBuy001MB.class);
		Root<RequestedItemBuy001MB> root = cq.from(RequestedItemBuy001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public RequestedItemBuy001MB getreqitembuy(int riId) {
		RequestedItemBuy001MB requseteditembuy001MB = entityManager.find(RequestedItemBuy001MB.class, riId);
		return requseteditembuy001MB;
	}

	public void deletereqitembuy(int riId) {
		RequestedItemBuy001MB requseteditembuy001MB = entityManager.find(RequestedItemBuy001MB.class, riId);
		entityManager.remove(requseteditembuy001MB);
	}
	
	//purchase history
	
	public void addpuitemhistory(PuItemHistory001MB puitemhistory001MB) {
		entityManager.merge(puitemhistory001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PuItemHistory001MB> listpuitemhistory() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PuItemHistory001MB> cq = builder.createQuery(PuItemHistory001MB.class);
		Root<PuItemHistory001MB> root = cq.from(PuItemHistory001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PuItemHistory001MB getpuitemhistory(int histId) {
		PuItemHistory001MB puitemhistory001MB = entityManager.find(PuItemHistory001MB.class, histId);
		return puitemhistory001MB;
	}

	public void deletepuitemhistory(int histId) {
		PuItemHistory001MB puitemhistory001MB = entityManager.find(PuItemHistory001MB.class, histId);
		entityManager.remove(puitemhistory001MB);
	}
	
	
	
	
	
	
	
	

}
