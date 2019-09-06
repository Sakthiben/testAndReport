package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemdtDAO;
import com.karya.model.Itemdt001MB;
import com.karya.model.Order001MB;
import com.karya.model.SalesOrder001MB;
import com.karya.service.IItemdtService;

@Service("ItemdtService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemdtService implements IItemdtService {
	
	@Autowired
	private IItemdtDAO itemdtDAO;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void itemdtAddAction(Itemdt001MB itemdt001MB) {
		itemdtDAO.itemdtAddAction(itemdt001MB);
	}
	
	public Itemdt001MB itemdtEditAction(int itemId){
		return itemdtDAO.itemdtEditAction(itemId);
	}
	
	public void itemdtDeleteAction(int itemId){
		itemdtDAO.itemDeleteAction(itemId);
	}
	public List<Itemdt001MB> listallItems() {
		return itemdtDAO.listallItems();
	}
	
	public List<SalesOrder001MB> listallSOrder(){
		return itemdtDAO.listallSOrder();
	}
	
	public List<Order001MB> listallOrder(){
		return itemdtDAO.listallOrder();
	}
	
	public void orderAdd(Order001MB order001mb){
		itemdtDAO.orderAdd(order001mb);
	}
	
	public void orderDelete(int orderId){
		itemdtDAO.orderDelete(orderId);
	}
	
	public Order001MB orderEdit(int orderId){
		return itemdtDAO.orderEdit(orderId);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void soAdd(SalesOrder001MB salesOrder){
		itemdtDAO.soAdd(salesOrder);
	}
	
	public void soDelete(int salesId){
		itemdtDAO.soDelete(salesId);
	}
	
	public SalesOrder001MB soEdit(int salesId){
		return itemdtDAO.soEdit(salesId);
	}
}	
	
