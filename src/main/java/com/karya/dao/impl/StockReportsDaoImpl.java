package com.karya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karya.model.RequestItemTransfer001MB;
import com.karya.dao.IStockReportsDao;
import com.karya.model.ItemPriceReport001MB;
import com.karya.model.ItemShortageReport001MB;
import com.karya.model.ItemWiseLevel001MB;
import com.karya.model.OrderItemsDelivered001MB;
import com.karya.model.PurItemsOrderReceived001MB;

@Repository
@Transactional
public class StockReportsDaoImpl implements IStockReportsDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addorderitemsdeliver(OrderItemsDelivered001MB orderitemsdeliver001MB) {
		entityManager.merge(orderitemsdeliver001MB);
	}

	@SuppressWarnings("unchecked")
	public List<OrderItemsDelivered001MB> listorderitemsdeliver() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OrderItemsDelivered001MB> cq = builder.createQuery(OrderItemsDelivered001MB.class);
		Root<OrderItemsDelivered001MB> root = cq.from(OrderItemsDelivered001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public OrderItemsDelivered001MB getorderitemsdeliver(int orditemsId) {
		OrderItemsDelivered001MB orderitemsdeliver001MB = entityManager.find(OrderItemsDelivered001MB.class, orditemsId);
		return orderitemsdeliver001MB;
	}

	public void deleteorderitemsdeliver(int orditemsId) {
		OrderItemsDelivered001MB orderitemsdeliver001MB = entityManager.find(OrderItemsDelivered001MB.class, orditemsId);
		entityManager.remove(orderitemsdeliver001MB);
	}
	
	//Purchase items order
	
	public void addpuritemsordrec(PurItemsOrderReceived001MB puritemsorderreceived001MB) {
		entityManager.merge(puritemsorderreceived001MB);
	}

	@SuppressWarnings("unchecked")
	public List<PurItemsOrderReceived001MB> listpuritemsordrec() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PurItemsOrderReceived001MB> cq = builder.createQuery(PurItemsOrderReceived001MB.class);
		Root<PurItemsOrderReceived001MB> root = cq.from(PurItemsOrderReceived001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public PurItemsOrderReceived001MB getpuritemsordrec(int poitrecId) {
		PurItemsOrderReceived001MB puritemsorderreceived001MB = entityManager.find(PurItemsOrderReceived001MB.class, poitrecId);
		return puritemsorderreceived001MB;
	}

	public void deletepuritemsordrec(int poitrecId) {
		PurItemsOrderReceived001MB puritemsorderreceived001MB = entityManager.find(PurItemsOrderReceived001MB.class, poitrecId);
		entityManager.remove(puritemsorderreceived001MB);
	}
	
	//Item Shortage Report
	

	public void additemshortreport(ItemShortageReport001MB itemshortagereport001MB) {
		entityManager.merge(itemshortagereport001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemShortageReport001MB> listitemshortreport() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemShortageReport001MB> cq = builder.createQuery(ItemShortageReport001MB.class);
		Root<ItemShortageReport001MB> root = cq.from(ItemShortageReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemShortageReport001MB getitemshortreport(int shrepid) {
		ItemShortageReport001MB itemshortagereport001MB = entityManager.find(ItemShortageReport001MB.class, shrepid);
		return itemshortagereport001MB;
	}

	public void deleteitemshortreport(int shrepid) {
		ItemShortageReport001MB itemshortagereport001MB = entityManager.find(ItemShortageReport001MB.class, shrepid);
		entityManager.remove(itemshortagereport001MB);
	}
	
	
	//request item transfer
	
	public void addrequestitemtransfer(RequestItemTransfer001MB requestitemtransfer001MB) {
		entityManager.merge(requestitemtransfer001MB);
	}

	@SuppressWarnings("unchecked")
	public List<RequestItemTransfer001MB> listrequestitemtransfer() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<RequestItemTransfer001MB> cq = builder.createQuery(RequestItemTransfer001MB.class);
		Root<RequestItemTransfer001MB> root = cq.from(RequestItemTransfer001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public RequestItemTransfer001MB getrequestitemtransfer(int ittransId) {
		RequestItemTransfer001MB requestitemtransfer001MB = entityManager.find(RequestItemTransfer001MB.class, ittransId);
		return requestitemtransfer001MB;
	}

	public void deleterequestitemtransfer(int ittransId) {
		RequestItemTransfer001MB requestitemtransfer001MB = entityManager.find(RequestItemTransfer001MB.class, ittransId);
		entityManager.remove(requestitemtransfer001MB);
	}
	
	//Item price report
	
	public void additempricereport(ItemPriceReport001MB itempricereportr001MB) {
		entityManager.merge(itempricereportr001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemPriceReport001MB> listitempricereport() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemPriceReport001MB> cq = builder.createQuery(ItemPriceReport001MB.class);
		Root<ItemPriceReport001MB> root = cq.from(ItemPriceReport001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemPriceReport001MB getitempricereport(int itpricesId) {
		ItemPriceReport001MB itempricereportr001MB = entityManager.find(ItemPriceReport001MB.class, itpricesId);
		return itempricereportr001MB;
	}

	public void deleteitempricereport(int itpricesId) {
		ItemPriceReport001MB itempricereportr001MB = entityManager.find(ItemPriceReport001MB.class, itpricesId);
		entityManager.remove(itempricereportr001MB);
	}
	
	//Item wise level
	
	public void additemwiselevel(ItemWiseLevel001MB itemwiselevel001MB) {
		entityManager.merge(itemwiselevel001MB);
	}

	@SuppressWarnings("unchecked")
	public List<ItemWiseLevel001MB> listitemwiselevel() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemWiseLevel001MB> cq = builder.createQuery(ItemWiseLevel001MB.class);
		Root<ItemWiseLevel001MB> root = cq.from(ItemWiseLevel001MB.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	public ItemWiseLevel001MB getitemwiselevel(int iwlId) {
		ItemWiseLevel001MB itemwiselevel001MB = entityManager.find(ItemWiseLevel001MB.class, iwlId);
		return itemwiselevel001MB;
	}

	public void deleteitemwiselevel(int iwlId) {
		ItemWiseLevel001MB itemwiselevel001MB = entityManager.find(ItemWiseLevel001MB.class, iwlId);
		entityManager.remove(itemwiselevel001MB);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
