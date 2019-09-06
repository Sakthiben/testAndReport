package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.model.RequestItemTransfer001MB;
import com.karya.dao.IStockReportsDao;
import com.karya.model.ItemPriceReport001MB;
import com.karya.model.ItemShortageReport001MB;
import com.karya.model.ItemWiseLevel001MB;
import com.karya.model.OrderItemsDelivered001MB;
import com.karya.model.PurItemsOrderReceived001MB;
import com.karya.service.IStockReportsService;

@Service("stockreportsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockReportsServiceImpl implements IStockReportsService{
	
	@Autowired
	private IStockReportsDao stockreportsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addorderitemsdeliver(OrderItemsDelivered001MB orderitemsdeliver001MB) {
		stockreportsDao.addorderitemsdeliver(orderitemsdeliver001MB);
	}
	
	public List<OrderItemsDelivered001MB> listorderitemsdeliver() {
		return stockreportsDao.listorderitemsdeliver();
	}

	public OrderItemsDelivered001MB getorderitemsdeliver(int orditemsId) {
		return stockreportsDao.getorderitemsdeliver(orditemsId);
	}
	
	public void deleteorderitemsdeliver(int orditemsId) {
		stockreportsDao.deleteorderitemsdeliver(orditemsId);
	}
	
	//purchase items order
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpuritemsordrec(PurItemsOrderReceived001MB puritemsorderreceived001MB) {
		stockreportsDao.addpuritemsordrec(puritemsorderreceived001MB);
	}
	
	public List<PurItemsOrderReceived001MB> listpuritemsordrec() {
		return stockreportsDao.listpuritemsordrec();
	}

	public PurItemsOrderReceived001MB getpuritemsordrec(int poitrecId) {
		return stockreportsDao.getpuritemsordrec(poitrecId);
	}
	
	public void deletepuritemsordrec(int poitrecId) {
		stockreportsDao.deletepuritemsordrec(poitrecId);
	}
	
	//item shortage report
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemshortreport(ItemShortageReport001MB itemshortagereport001MB) {
		stockreportsDao.additemshortreport(itemshortagereport001MB);
	}
	
	public List<ItemShortageReport001MB> listitemshortreport() {
		return stockreportsDao.listitemshortreport();
	}

	public ItemShortageReport001MB getitemshortreport(int shrepid) {
		return stockreportsDao.getitemshortreport(shrepid);
	}
	
	public void deleteitemshortreport(int shrepid) {
		stockreportsDao.deleteitemshortreport(shrepid);
	}
	
	// request item transfer
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addrequestitemtransfer(RequestItemTransfer001MB requestitemtransfer001MB) {
		stockreportsDao.addrequestitemtransfer(requestitemtransfer001MB);
	}
	
	public List<RequestItemTransfer001MB> listrequestitemtransfer() {
		return stockreportsDao.listrequestitemtransfer();
	}

	public RequestItemTransfer001MB getrequestitemtransfer(int ittransId) {
		return stockreportsDao.getrequestitemtransfer(ittransId);
	}
	
	public void deleterequestitemtransfer(int ittransId) {
		stockreportsDao.deleterequestitemtransfer(ittransId);
	}
	
	//itemprice report
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additempricereport(ItemPriceReport001MB itempricereportr001MB) {
		stockreportsDao.additempricereport(itempricereportr001MB);
	}
	
	public List<ItemPriceReport001MB> listitempricereport() {
		return stockreportsDao.listitempricereport();
	}

	public ItemPriceReport001MB getitempricereport(int itpricesId) {
		return stockreportsDao.getitempricereport(itpricesId);
	}
	
	public void deleteitempricereport(int itpricesId) {
		stockreportsDao.deleteitempricereport(itpricesId);
	}
	
	//item wise level
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemwiselevel(ItemWiseLevel001MB itemwiselevel001MB) {
		stockreportsDao.additemwiselevel(itemwiselevel001MB);
	}
	
	public List<ItemWiseLevel001MB> listitemwiselevel() {
		return stockreportsDao.listitemwiselevel();
	}

	public ItemWiseLevel001MB getitemwiselevel(int iwlId) {
		return stockreportsDao.getitemwiselevel(iwlId);
	}
	
	public void deleteitemwiselevel(int iwlId) {
		stockreportsDao.deleteitemwiselevel(iwlId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
