package com.karya.dao;

import java.util.List;

import com.karya.model.RequestItemTransfer001MB;
import com.karya.model.ItemPriceReport001MB;
import com.karya.model.ItemShortageReport001MB;
import com.karya.model.ItemWiseLevel001MB;
import com.karya.model.OrderItemsDelivered001MB;
import com.karya.model.PurItemsOrderReceived001MB;

public interface IStockReportsDao {

	public void addorderitemsdeliver(OrderItemsDelivered001MB orderitemsdeliver001MB);

	public List<OrderItemsDelivered001MB> listorderitemsdeliver();
	
	public OrderItemsDelivered001MB getorderitemsdeliver(int orditemsId);
	
	public void deleteorderitemsdeliver(int orditemsId);
	
	//Purchase items order
	
	public void addpuritemsordrec(PurItemsOrderReceived001MB puritemsorderreceived001MB);

	public List<PurItemsOrderReceived001MB> listpuritemsordrec();
	
	public PurItemsOrderReceived001MB getpuritemsordrec(int poitrecId);
	
	public void deletepuritemsordrec(int poitrecId);
	
	//Item Shortage report
	
	public void additemshortreport(ItemShortageReport001MB itemshortagereport001MB);

	public List<ItemShortageReport001MB> listitemshortreport();
	
	public ItemShortageReport001MB getitemshortreport(int shrepid);
	
	public void deleteitemshortreport(int shrepid);
	
	//RequestItemTransfer
	
	public void addrequestitemtransfer(RequestItemTransfer001MB requestitemtransfer001MB);

	public List<RequestItemTransfer001MB> listrequestitemtransfer();
	
	public RequestItemTransfer001MB getrequestitemtransfer(int ittransId);
	
	public void deleterequestitemtransfer(int ittransId);
	
	//Item price report
	
	public void additempricereport(ItemPriceReport001MB itempricereportr001MB);

	public List<ItemPriceReport001MB> listitempricereport();
	
	public ItemPriceReport001MB getitempricereport(int itpricesId);
	
	public void deleteitempricereport(int itpricesId);
	
	//Item Wise level
	
	public void additemwiselevel(ItemWiseLevel001MB itemwiselevel001MB);

	public List<ItemWiseLevel001MB> listitemwiselevel();
	
	public ItemWiseLevel001MB getitemwiselevel(int iwlId);
	
	public void deleteitemwiselevel(int iwlId);
	
	
	
	
	
	
	
	
	
	
	
}
