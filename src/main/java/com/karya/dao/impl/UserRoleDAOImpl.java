
package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IUserRoleDAO;
import com.karya.model.Employee001MB;
import com.karya.model.Login001MB;
import com.karya.model.Role001MB;
import com.karya.model.UserRole001MB;


@Repository
@Transactional
public class UserRoleDAOImpl implements IUserRoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	@SuppressWarnings("unused")
	@Override
	public void userRoleAddAction(UserRole001MB  userrole001mb) {
		try {
        	entityManager.merge(userrole001mb);
        } catch(NoResultException exception) {
        	entityManager.persist(userrole001mb);
        }
	}
	
	public UserRole001MB userRoleEditAction(int id) {
		UserRole001MB userrole001mb = entityManager.find(UserRole001MB.class, id);
		return userrole001mb;
	}
	
	public void userRoleDeleteAction(int id) {
		UserRole001MB userrole001mb = entityManager.find(UserRole001MB.class, id);
		entityManager.remove(userrole001mb);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRole001MB> listallusers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserRole001MB> cq = builder.createQuery(UserRole001MB.class);
		Root<UserRole001MB> root = cq.from(UserRole001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();	
		
	}
	
	public List<Role001MB> getRoleList() throws DataAccessException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Role001MB> cq = builder.createQuery(Role001MB.class);
		Root<Role001MB> root = cq.from(Role001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
    }
	
	public List<Login001MB> getUserList() throws DataAccessException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Login001MB> cq = builder.createQuery(Login001MB.class);
		Root<Login001MB> root = cq.from(Login001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
    }
	
}