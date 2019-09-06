package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IFileManagerDao;
import com.karya.model.FileManager001MB;




@Repository
@Transactional
public class FileManagerDaoImpl implements IFileManagerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addfiles(FileManager001MB fileupload) {
     entityManager.merge(fileupload);


	}
	
	@SuppressWarnings("unused")
	public List<FileManager001MB> listFiles() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileManager001MB> cq = builder.createQuery(FileManager001MB.class);
		Root<FileManager001MB> root = cq.from(FileManager001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();	
	}
	
	public FileManager001MB getfile(int id) {
		FileManager001MB fileManager001MB = entityManager.find(FileManager001MB.class, id);
		return fileManager001MB;
	}
	
	public void deleteFiles(int id) {
	
		FileManager001MB fileManager001MB = entityManager.find(FileManager001MB.class, id);
		entityManager.remove(fileManager001MB);
	}

	
}