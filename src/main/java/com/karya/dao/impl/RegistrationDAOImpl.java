
package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IRegistrationDAO;
import com.karya.model.Login001MB;


@Repository
@Transactional
public class RegistrationDAOImpl implements IRegistrationDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save(Login001MB  login001MB) {
		if(login001MB.getId() != 0) {
			Login001MB login001MBTmp = entityManager.find(Login001MB.class,login001MB.getId());
			login001MB.setUsername(login001MBTmp.getUsername());
			login001MB.setPassword(login001MBTmp.getPassword());
			entityManager.merge(login001MB);
		} else {
			entityManager.persist(login001MB);
		}
	}
	
	@SuppressWarnings("unused")
	public List<Login001MB> listregisterpages() {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Login001MB> cq = builder.createQuery(Login001MB.class);
		Root<Login001MB> root = cq.from(Login001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	
	}
	
	public Login001MB getregisterpage(int id) {
		Login001MB securityquestionlists = entityManager.find(Login001MB.class,id);
		return securityquestionlists;
	}

	@Override
	public void deletepage(int id) {
		Login001MB securityquestionlists = entityManager.find(Login001MB.class,id);
		entityManager.remove(securityquestionlists);
		
	}
	
	// Change Username
	
	public Login001MB getusername(String username) {
		Login001MB securityquestionlists = entityManager.find(Login001MB.class,username);
		return securityquestionlists;
	}
	
	@SuppressWarnings("null")
	public void saveusername(String existingusername,String newusername) {
		Query query = entityManager.createQuery("select l from Login001MB l WHERE l.username = :username");
        query.setParameter("username", existingusername);
        Login001MB login001mb =  (Login001MB) query.getSingleResult();
		if(login001mb != null) {
			login001mb.setUsername(newusername); 
			entityManager.merge(login001mb);
		} else {
			login001mb.setMessage("Sorry! You have to Register First");
		}
	}
	
	// Change Password
	
	public void savepassword(String username,String newpassword) {
		Query query = entityManager.createQuery("select l from Login001MB l WHERE l.username = :username");
		query.setParameter("username", username);
        Login001MB login001mb = (Login001MB) query.getSingleResult();
		if(login001mb != null) {
			login001mb.setPassword(newpassword);
			entityManager.merge(login001mb);
		} else {
			login001mb.setMessage("Sorry! You have to Register First");
		}
	}
	public Login001MB getpassword(String password) {
		Login001MB securityquestionlists = entityManager.find(Login001MB.class,password);
		return securityquestionlists;
	}
}