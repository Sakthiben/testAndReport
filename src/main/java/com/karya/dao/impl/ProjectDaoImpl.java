package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProjectDAO;
import com.karya.model.Project001MB;


@Repository
@Transactional
public class ProjectDaoImpl implements IProjectDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addproject(Project001MB project) {
		if(project.getId() == 0){
			entityManager.persist(project);	
		}else
			entityManager.merge(project);
		}
	
	public List<Project001MB> listproject() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Project001MB> cq = builder.createQuery(Project001MB.class);
		Root<Project001MB> root = cq.from(Project001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}


	public Project001MB getproject(int id) {
		Project001MB project = entityManager.find(Project001MB.class, id);
		return project;
	}


	public void deleteproject(int id) {
		Project001MB project  = entityManager.find(Project001MB.class,id);
		entityManager.remove(project);	
	}
	
	


}	
	
	
	
	
	
	
	
	