package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IDailyTimeSheetDAO;
import com.karya.model.DailyTimesheet001MB;

@Repository
@Transactional
public class DailyTimesheetDAO implements IDailyTimeSheetDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void adddailytimesheet(DailyTimesheet001MB dailytimesheet) {
		entityManager.merge(dailytimesheet);
	}
	
	@SuppressWarnings("unchecked")
	public List<DailyTimesheet001MB> dailytimesheet() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<DailyTimesheet001MB> cq = builder.createQuery(DailyTimesheet001MB.class);
		Root<DailyTimesheet001MB> root = cq.from(DailyTimesheet001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public DailyTimesheet001MB getDailyTimesheet(int id) {
		DailyTimesheet001MB dailytimesheet = entityManager.find(DailyTimesheet001MB.class, id);
		return dailytimesheet;
	}

	public void deleteDailyTimesheet(int id) {
		DailyTimesheet001MB dailytimesheet = entityManager.find(DailyTimesheet001MB.class, id);
		entityManager.remove(dailytimesheet);
	}

}
