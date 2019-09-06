package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IGrossProfitDAO;
import com.karya.model.GrossProfit001MB;

@Repository
@Transactional
public class GrossProfitDAO implements IGrossProfitDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addgrossprofit(GrossProfit001MB grossprofit) {
		entityManager.merge(grossprofit);
	}
	
	@SuppressWarnings("unchecked")
	public List<GrossProfit001MB> grossprofitlist() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<GrossProfit001MB> cq = builder.createQuery(GrossProfit001MB.class);
		Root<GrossProfit001MB> root = cq.from(GrossProfit001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public GrossProfit001MB getGrossprofit(int id) {
		GrossProfit001MB grossprofit = entityManager.find(GrossProfit001MB.class, id);
		return grossprofit;
	}

	public void deletegrossprofit(int id) {
		GrossProfit001MB grossprofit = entityManager.find(GrossProfit001MB.class, id);
		entityManager.remove(grossprofit);
	}
}
