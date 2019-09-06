package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITestCaseDAO;
import com.karya.model.TestCase001MB;


@Repository
@Transactional
public class TestCaseDAO implements ITestCaseDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<TestCase001MB> getAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestCase001MB> cq = builder.createQuery(TestCase001MB.class);
		Root<TestCase001MB> root = cq.from(TestCase001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public void add(TestCase001MB testCase001MB) {
		entityManager.persist(testCase001MB);
		
	}

	@Override
	public void delete(Long id) {
		TestCase001MB testCase001MB = entityManager.find(TestCase001MB.class, id);
		entityManager.remove(testCase001MB);
	}

	@Override
	public void edit(TestCase001MB testCase001MB) {
		entityManager.merge(testCase001MB);
	}
	

}
