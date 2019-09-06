package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.ICustomerDAO;
import com.karya.model.CustomerAcquisition001MB;
import com.karya.model.CustomerCreditBalance001MB;
import com.karya.model.CustomerDetails001MB;

@Repository
@Transactional
public class CustomerDAO implements ICustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* Customer Acquisition */
	
	public void addCustomerAcquisition(CustomerAcquisition001MB customeracquisition) {
		entityManager.merge(customeracquisition);
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerAcquisition001MB> listcustomerAcquisition() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerAcquisition001MB> cq = builder.createQuery(CustomerAcquisition001MB.class);
		Root<CustomerAcquisition001MB> root = cq.from(CustomerAcquisition001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
	
	public CustomerAcquisition001MB getCustomerAcquisition(int id) {
		CustomerAcquisition001MB customeracquisition = entityManager.find(CustomerAcquisition001MB.class, id);
		return customeracquisition;
	}

	public void deleteCustomerAcquisition(int id) {
		CustomerAcquisition001MB customeracquisition = entityManager.find(CustomerAcquisition001MB.class, id);
		entityManager.remove(customeracquisition);
	}
	
	/* Customer Credit Balance */
	
	public void addCustomercreditbalance(CustomerCreditBalance001MB customercreditbalance) {
			entityManager.merge(customercreditbalance);
		}
	
	
	@SuppressWarnings("unchecked")
	public List<CustomerCreditBalance001MB> listcustomercreditbalance() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerCreditBalance001MB> cq = builder.createQuery(CustomerCreditBalance001MB.class);
		Root<CustomerCreditBalance001MB> root = cq.from(CustomerCreditBalance001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CustomerCreditBalance001MB getCustomercreditbalance(int ccid) {
		CustomerCreditBalance001MB customercreditbalance = entityManager.find(CustomerCreditBalance001MB.class, ccid);
		return customercreditbalance;
	}

	public void deleteCustomercreditbalance(int ccid) {
		CustomerCreditBalance001MB customercreditbalance = entityManager.find(CustomerCreditBalance001MB.class, ccid);
		entityManager.remove(customercreditbalance);
	}
	
	/* Customer Details */
	
	public void addCustomerdetails(CustomerDetails001MB customerdetails) {
		entityManager.merge(customerdetails);
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerDetails001MB> listcustomerdetails() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails001MB> cq = builder.createQuery(CustomerDetails001MB.class);
		Root<CustomerDetails001MB> root = cq.from(CustomerDetails001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public CustomerDetails001MB getCustomerdetails(int id) {
		CustomerDetails001MB customerdetails = entityManager.find(CustomerDetails001MB.class, id);
		return customerdetails;
	}

	public void deleteCustomerdetails(int id) {
		CustomerDetails001MB customerdetails = entityManager.find(CustomerDetails001MB.class, id);
		entityManager.remove(customerdetails);
	}

}
