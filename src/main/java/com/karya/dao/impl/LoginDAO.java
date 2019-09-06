package com.karya.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.karya.dao.ILoginDAO;
import com.karya.model.Login001MB;
import com.karya.model.Menu001MB;
 

@Repository
public class LoginDAO implements ILoginDAO {
 
	@PersistenceContext
    protected EntityManager entityManager;
 
    public Login001MB getLoginResult(String username, String password) throws DataAccessException {
		Login001MB resultList =  null;
		try {
	        Query query = entityManager.createQuery("select l from Login001MB l WHERE l.username = :username and l.password=:password");
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        resultList =  (Login001MB)query.getSingleResult();
	        if(resultList!=null) {
	        	if (resultList.isEnabled()) {
	        		return resultList;
	        	} else {
	        		resultList.setMessage("User is Inactive");
	        	}
	        }
		} catch(NoResultException ex) {
			resultList = new Login001MB();
			resultList.setMessage("User Unavailable");
		}
       return resultList;
    }
    
    @SuppressWarnings("unchecked")
	public List<Menu001MB> getMenuLink(String domain) throws DataAccessException,NoResultException {
    	List<Menu001MB> resultList =  null;
		try {
	        Query query = entityManager.createQuery("select l from Menu001MB l WHERE l.domain = :domain");
	        query.setParameter("domain", domain);
	        resultList =  (ArrayList<Menu001MB>)query.getResultList();
		} catch(NoResultException ex) {
			throw new NoResultException();
		}
       return resultList;
    }
	
    public Login001MB getLoginResult(String username) throws NoResultException,DataAccessException {
		Login001MB resultList =  null;
		try {
	        Query query = entityManager.createQuery("select l from Login001MB l WHERE l.username = :username");
	        query.setParameter("username", username);
	        resultList =  (Login001MB)query.getSingleResult();
		} catch(NoResultException ex) {
			return null;
		} catch(Exception ex) {
			return null;
		}
       return resultList;
    }
}