package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITaskDAO;
import com.karya.model.Task001MB;


@Repository
@Transactional
public class TaskDaoImpl implements ITaskDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addTask(Task001MB task) {
		entityManager.merge(task);
	}
	
	
	@SuppressWarnings("unused")
	public List<Task001MB> listTask() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task001MB> cq = builder.createQuery(Task001MB.class);
		Root<Task001MB> root = cq.from(Task001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	
	}
	
	 public Task001MB getTask(int taskid) {
		Task001MB task = entityManager.find(Task001MB.class, taskid);
		return task;
	}

	public void deleteTask(int taskid) {
		Task001MB task  = entityManager.find(Task001MB.class,taskid);
		entityManager.remove(task);
	}
		
}
