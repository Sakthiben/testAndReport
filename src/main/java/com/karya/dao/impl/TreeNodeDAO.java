package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ITreeNodeDAO;

import com.karya.model.TreeNode001MB;


@Repository
@Transactional
public class TreeNodeDAO implements ITreeNodeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<TreeNode001MB> getAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TreeNode001MB> cq = builder.createQuery(TreeNode001MB.class);
		Root<TreeNode001MB> root = cq.from(TreeNode001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public void add(TreeNode001MB treeNode) {
		entityManager.persist(treeNode);
	}

	@Override
	public void delete(Long id) {
		TreeNode001MB treeNode = entityManager.find(TreeNode001MB.class, id);
		entityManager.remove(treeNode);
	}

	@Override
	public void edit(TreeNode001MB treeNode) {
		entityManager.merge(treeNode);
	}
	


}
