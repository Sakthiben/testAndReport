package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemWisePurRegisterDao;
import com.karya.model.ItemWisePurRegister001MB;
import com.karya.model.PaymentEntry001MB;
import com.karya.model.PaymentRequest001MB;

@Repository
@Transactional
public class ItemWisePurRegisteDaoImpl implements IItemWisePurRegisterDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void additemwisepurregister(ItemWisePurRegister001MB itemwisepurregiste001mb) {
		entityManager.merge(itemwisepurregiste001mb);
	}

	@SuppressWarnings("unchecked")
	public List<ItemWisePurRegister001MB> listitemwisepurregister() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemWisePurRegister001MB> cq = builder.createQuery(ItemWisePurRegister001MB.class);
		Root<ItemWisePurRegister001MB> root = cq.from(ItemWisePurRegister001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemWisePurRegister001MB getitemwisepurregister(int iwprId) {
		ItemWisePurRegister001MB itemwisepurregiste001mb = entityManager.find(ItemWisePurRegister001MB.class, iwprId);
		return itemwisepurregiste001mb;
	}

	public void deleteitemwisepurregister(int iwprId) {
		ItemWisePurRegister001MB itemwisepurregiste001mb = entityManager.find(ItemWisePurRegister001MB.class, iwprId);
		entityManager.remove(itemwisepurregiste001mb);
	}
	
	//Payment Request
	
	public void addpaymentrequest(PaymentRequest001MB paymentrequest001mb) {
		entityManager.merge(paymentrequest001mb);
	}

	@SuppressWarnings("unchecked")
	public List<PaymentRequest001MB> listpaymentrequest() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PaymentRequest001MB> cq = builder.createQuery(PaymentRequest001MB.class);
		Root<PaymentRequest001MB> root = cq.from(PaymentRequest001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PaymentRequest001MB getpaymentrequest(int payreqId) {
		PaymentRequest001MB paymentrequest001mb = entityManager.find(PaymentRequest001MB.class, payreqId);
		return paymentrequest001mb;
	}

	public void deletepaymentrequest(int payreqId) {
		PaymentRequest001MB paymentrequest001mb = entityManager.find(PaymentRequest001MB.class, payreqId);
		entityManager.remove(paymentrequest001mb);
	}
	
	//Payment entry
	
		public void addpaymententry(PaymentEntry001MB paymententry001mb) {
			entityManager.merge(paymententry001mb);
		}

		@SuppressWarnings("unchecked")
		public List<PaymentEntry001MB> listpaymententry() {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<PaymentEntry001MB> cq = builder.createQuery(PaymentEntry001MB.class);
			Root<PaymentEntry001MB> root = cq.from(PaymentEntry001MB.class);
			cq.select(root);
			return entityManager.createQuery(cq).getResultList();
		}

		public PaymentEntry001MB getpaymententry(int payentId) {
			PaymentEntry001MB paymententry001mb = entityManager.find(PaymentEntry001MB.class, payentId);
			return paymententry001mb;
		}

		public void deletepaymententry(int payentId) {
			PaymentEntry001MB paymententry001mb = entityManager.find(PaymentEntry001MB.class, payentId);
			entityManager.remove(paymententry001mb);
		}
		
		

}
